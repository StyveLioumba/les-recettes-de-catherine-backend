package com.bdx.anais.ApplicationRecetteCuisine.shared;

import com.bdx.anais.ApplicationRecetteCuisine.shared.model.MetaData;
import org.springframework.data.domain.Page;

public class Utils {
    public static MetaData getMetaData(Page<?> myPage) {
        return new MetaData(
                (int) myPage.getTotalElements(),
                myPage.getTotalPages(),
                String.valueOf(myPage.getNumber()),
                String.valueOf(myPage.getSize()),
                myPage.hasPrevious() ? String.valueOf(myPage.getNumber() - 1) : String.valueOf(0),
                myPage.hasNext() ? String.valueOf(myPage.getNumber() + 1) : String.valueOf(0)
        );
    }
}
