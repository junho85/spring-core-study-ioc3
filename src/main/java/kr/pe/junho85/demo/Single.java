package kr.pe.junho85.demo;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {

    @Autowired
    private Proto proto;
//    private ObjectProvider<Proto> proto;

    public Proto getProto() {
//        return proto.getIfAvailable();
        return proto;
    }
}
