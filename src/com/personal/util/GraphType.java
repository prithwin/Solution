package com.personal.util;

/**
 * Created by pr250155 on 4/30/17.
 */
public enum GraphType {
    UNDIRECTED_MATRIX {
        public boolean isDirected() {
            return false;
        }

        public boolean isMatrix() {
            return true;
        }

        public boolean isList() {
            return false;
        }
    },
    UNDIRECTED_LIST {
        public boolean isDirected() {
            return false;
        }

        public boolean isMatrix() {
            return false;
        }

        public boolean isList() {
            return true;
        }
    },
    DIRECTED_MATRIX {
        public boolean isDirected() {
            return true;
        }

        public boolean isMatrix() {
            return true;
        }

        public boolean isList() {
            return false;
        }
    };

    public abstract boolean isDirected();

    public abstract boolean isMatrix();

    public abstract boolean isList();
}
