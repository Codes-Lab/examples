////////////////////////////////////////////////////////////////////////////////
//
// Created by AMundewal on 19.04.2022.
//
// Copyright (c) 2006 - 2022 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.practice.codility.lessions.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 */
public class VisitCounter2 {

    //Map contains Microservice and UserStats.
    public Map<Long, Long> count(Map<String, UserStats>... visits) {
        final Map<Long, Long> numberOfVisits = new HashMap<>();
        for (Map<String, UserStats> entry : visits) {
            if (entry == null) {
                continue;
            }
            for (String id : entry.keySet()) {
                if (isValidLongValue(id)) {
                    final UserStats userStats = entry.get(id);
                    if (userStats != null) {
                        final Optional<Long> visitCount = userStats.getVisitCount();
                        if (visitCount.isPresent()) {
                            final Long parseLong = Long.parseLong(id);
                            if (numberOfVisits.get(parseLong) == null) {
                                numberOfVisits.put(parseLong, visitCount.get());
                            } else {
                                final Long currentCount = numberOfVisits.get(parseLong);
                                final long newCount = currentCount + visitCount.get();
                                numberOfVisits.put(parseLong, newCount);
                            }
                        }
                    }
                }
            }
        }
        return numberOfVisits;
    }

    private boolean isValidLongValue(String ids) {
        try {
            Long.parseLong(ids);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
