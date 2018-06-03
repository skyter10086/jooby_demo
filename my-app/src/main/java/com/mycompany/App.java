package com.mycompany;

import org.jooby.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.typesafe.config.Config;

/**
 * @author jooby generator
 */
public class App extends Jooby {
   //RequestLogger logger = new RequestLogger();
   final static Logger logger = LoggerFactory.getLogger(App.class);
  {
    
    use("*", new RequestLogger());
    onStart(() -> {
      logger.info("Well, it is getting on!");
    });
    onStop(() -> {
      logger.info("See ya!");
    });
    get("/", () -> "Hello Jooby!");
    get("/index", (req, rsp) -> {
      Config conf = require(Config.class);
      String myprop = conf.getString("myprop");
      rsp.send(myprop);

    });
  }

  public static void main(final String[] args) {
    run(App::new, args);
  }

}
