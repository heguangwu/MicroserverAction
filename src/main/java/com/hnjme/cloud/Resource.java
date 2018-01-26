package com.hnjme.cloud;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: HeGuangwu (heguangwu@163.com)
 * Description:
 * Date: Create in 2018/01/26
 * Modified By:
 */
@Path("demo")
public class Resource {
    @GET
    @Path("/hi")
    public String getStringMessage() {
        return "hi, this is a hello world of restful";
    }
    @GET
    @Path("/hello")
    @Produces("application/json")
    public Info getJsonMessage(){
        Info info = new Info("hi", true);
        List<String> names = Arrays.asList("Dennis", "Bjarne", "James");
        info.setList(names);
        return info;
    }

    @XmlRootElement(name="info")
    private class Info {
        private String message;
        private Boolean success;
        private List<String> list = new ArrayList<String>();

        public Info(String message, Boolean bool){
            this.message = message;
            this.success = bool;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public List<String> getLIst() {
            return list;
        }

        public void setList(List<String> list) {
            this.list.addAll(list);
        }
    }
}
