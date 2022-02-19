package org.github.zsun.java.puruantraining.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String urlPath = exchange.getRequest().getURI().getPath();
        System.out.println(urlPath);
        if (!urlPath.contains("hacker")) {
            return chain.filter(exchange);
        } else {
            ServerHttpResponse res = exchange.getResponse();
            String msg = "fail for hacker";
            byte[] bits = msg.getBytes();
            DataBuffer buf = res.bufferFactory().wrap(bits);
            res.setStatusCode(HttpStatus.BAD_REQUEST);
            res.getHeaders().add("Content-Type", "text/plain");
            return res.writeWith(Mono.just(buf));
        }
    }

    @Override
    public int getOrder() {
        //Order值越小，优先级越高
        return 0;
    }
}
