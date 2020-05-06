package cn.cqsw.controller.filter;

import javax.servlet.*;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SenseWordFilter
 * Description:敏感词拦截
 * date: 2020/5/6 0006 16:56:46
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class SenseWordFilter implements Filter {
    //创建一个集合来存储敏感词汇
    private List<String> senseWords = null;

    @Override
    public void init(FilterConfig filterConfig) {
        senseWords = new ArrayList<String>();
        //将敏感词汇读取到集合里
        File file = new File("E:\\Work\\idea\\MyCampusMyHome\\src\\main\\resources\\sense_word.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                senseWords.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doFilter(final ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //用类反射和代理模式
        //先获取getParameter的方法，然后执行该方法获取Value值后判断value是不是有敏感词汇
        //如果有的话，敏感词汇用*代替
        //如果没有，正常的返回value值最后放行
        servletRequest.setCharacterEncoding("utf-8");
        ServletRequest proxyRequest = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(servletRequest, args);
                    if (value != null) {
                        for (String senseWord : senseWords) {
                            if (value.contains(senseWord)) {
                                String word = "";
                                for (int i = 0; i < senseWord.length(); i++) {
                                    word += "*";
                                }
                                value = value.replaceAll(senseWord, word);

                            }
                        }
                        return value;
                    }
                }
                return method.invoke(servletRequest, args);
            }
        });
        //放行
        filterChain.doFilter(proxyRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
