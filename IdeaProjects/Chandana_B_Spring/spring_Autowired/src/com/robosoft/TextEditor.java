package com.robosoft;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor
    {
        private SpellChecker spellchecker;


        public SpellChecker getSpellchecker()
        {
            return spellchecker;
        }
        @Autowired
        public void setSpellchecker(SpellChecker spellchecker)
        {
            this.spellchecker = spellchecker;
        }
        public void spellCheck()
        {
            spellchecker.checkSpelling();    //calling the methods of Spellchecker class
        }
    }
