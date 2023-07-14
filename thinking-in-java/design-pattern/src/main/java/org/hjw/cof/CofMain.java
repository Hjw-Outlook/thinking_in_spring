package org.hjw.cof;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageClassName: org.hjw.cof.CofMain
 * @Description: chain of responsibility 责任链模式
 * @Author: JerryH
 * @Date: 2023-07-13, 0013 上午 09:57
 */
public class CofMain {

    public static void main(String[] args) {
        String msg = "大家好，我是123，你是456！";
        FilterChain filterChain = new FilterChain();
        Request request = new Request(msg);
        Response response = new Response(msg);
        filterChain.add(request).add(response);
        filterChain.doFilter(request, response, filterChain);
    }
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain filterChain);
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        if (index > filters.size() - 1) return false;
        Filter filter = filters.get(index);
        index++;
        return filter.doFilter(request, response, filterChain);
    }
}

class Request implements Filter {
    String reqMsg;

    public Request(String msg) {
        this.reqMsg = msg;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        String msg = request.reqMsg;
        request.reqMsg = msg.replace("123", "321");
        System.out.println("request replace start...." + request.reqMsg);
        filterChain.doFilter(request, response, filterChain);
        System.out.println("request replace end....");
        return true;
    }
}

class Response implements Filter {
    String resMsg;

    public Response(String msg) {
        this.resMsg = msg;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        String msg = response.resMsg;
        response.resMsg = msg.replace("456", "654");
        System.out.println("response replace start......" + response.resMsg);
        filterChain.doFilter(request, response, filterChain);
        System.out.println("response replace end......");
        return true;
    }
}