package com.picture.service.service.util;

import com.picture.service.config.PropertyConfig;

import java.util.Optional;

public class PictureUtil {

    public static boolean validCategory(String category) {

        PropertyConfig properties = StaticContextAccessor.getBean(PropertyConfig.class);

        return properties.getImageCategories().contains(category);
    }

    public static boolean validExtension(String extension) {

        PropertyConfig properties = StaticContextAccessor.getBean(PropertyConfig.class);

        return properties.getImageExtensions().contains(extension);
    }

    public static String getFileExtension(String filename) {

        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename
                        .lastIndexOf(".") + 1))
                .orElse("");
    }

}
