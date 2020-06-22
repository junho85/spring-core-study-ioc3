package kr.pe.junho85.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    Single single;

    @Autowired
    Proto proto;

    @Autowired
    ApplicationContext ctx;

    @Autowired
    MessageSource messageSource;

    @Autowired
    BookRepository bookRepository;

    @Value("${app.name}")
    String appName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(proto);
        System.out.println(single.getProto());

        System.out.println("proto");
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));

        System.out.println("single");
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));

        System.out.println("proto by single");
        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());

        Environment environment = ctx.getEnvironment();
        System.out.println(Arrays.toString(environment.getActiveProfiles())); // []
        System.out.println(Arrays.toString(environment.getDefaultProfiles())); // [default]

        System.out.println(environment.getProperty("app.name"));
        System.out.println(appName);
//        System.out.println(environment.getProperty("app.about"));

        while (true) {
            System.out.println(messageSource.getClass()); // ResourceBundleMessageSource 가 빈으로 등록되어 있음
            System.out.println(messageSource.getMessage("greeting", new String[]{"june"}, Locale.KOREA));
            System.out.println(messageSource.getMessage("greeting", new String[]{"june"}, Locale.getDefault()));

            Thread.sleep(1000);
        }
    }
}
