package com.bankapp.enums;

/**
 * Enum representing different repetition rules for transactions or payments in the bank application.
 */
public enum RepetitionRule {
    /**
     * Repeats every month during the first week.
     */
    EVERY_MONTH_FIRST_WEEK,

    /**
     * Repeats every month during the last week.
     */
    EVERY_MONTH_LAST_WEEK,

    /**
     * Repeats every week.
     */
    EVERY_WEEK,

    /**
     * Repeats every three months (trimester).
     */
    EVERY_TRIMESTER,

    /**
     * Repeats every six months (semester).
     */
    EVERY_SEMESTER,

    /**
     * Repeats every year.
     */
    EVERY_YEAR
}
