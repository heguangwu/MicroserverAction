package com.hnjme.cloud;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: HeGuangwu (heguangwu@163.com)
 * Description:
 * Date: Create in 2018/01/26
 * Modified By:
 */
public class ResourceApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set set = new HashSet();
        set.add(Resource.class);
        return set;
    }
}
