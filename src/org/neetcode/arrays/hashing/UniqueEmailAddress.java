package org.neetcode.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        Set<String> fixedEmails = new HashSet<>();
        for(String email: emails) {
            String[] split = email.split("@");
            String local = split[0].replace(".","");
            String[] l = local.split("\\+");
            fixedEmails.add(l[0]+"@"+split[1]);
        }
        return fixedEmails.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddress emailAddress = new UniqueEmailAddress();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(emailAddress.numUniqueEmails(emails));
    }
}
