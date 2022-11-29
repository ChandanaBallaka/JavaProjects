package com.robosoft;

public class Student {
        private int id;
        String stdName;

        public Student(int id, String stdName)
        {
                this.id = id;
                this.stdName = stdName;

        }

        public int getId()
        {
                return id;
        }

        public void setId(int id)
        {
                this.id = id;
        }

        public String getStdName()
        {
                return stdName;
        }

        public void setStdName(String stdName)
        {
                this.stdName = stdName;
        }
}
