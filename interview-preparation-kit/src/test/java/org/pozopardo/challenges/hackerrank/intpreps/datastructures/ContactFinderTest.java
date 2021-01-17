package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ContactFinderTest {

    Map<String, Integer> contactsLookup;

    @Before
    public void cleanUp() {
        contactsLookup = new HashMap<>();
    }

    @Test
    public void testContactsWithHashMap() {
        String contact = "hack";
        ContactFinderWithHashMap.add(contactsLookup, contact);
        assertEquals(4, contactsLookup.size());

        contact = "hackerrank";
        ContactFinderWithHashMap.add(contactsLookup, contact);
        assertEquals(10, contactsLookup.size());

        contact = "hac";
        assertEquals(2, ContactFinderWithHashMap.find(contactsLookup, contact));

        contact = "hak";
        assertEquals(0, ContactFinderWithHashMap.find(contactsLookup, contact));
    }

    @Test
    public void testContactsWithTries() {
        ContactFinderWithTries trie = new ContactFinderWithTries();
        String contact = "hack";
        trie.add(contact);

        contact = "hackerrank";
        trie.add(contact);

        contact = "hac";
        assertEquals(2, trie.find(contact));

        contact = "hak";
        assertEquals(0, trie.find(contact));
    }
}
