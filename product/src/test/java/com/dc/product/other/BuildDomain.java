package com.dc.product.other;

public class BuildDomain {

    private String name;
    private String idCard;
    private boolean sex;

    public BuildDomain(String name, String idCard, boolean sex) {
        this.name = name;
        this.idCard = idCard;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getIdCard() {
        return idCard;
    }

    public boolean isSex() {
        return sex;
    }

    public String toString() {
        return "BuildDomain{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sex=" + sex +
                '}';
    }

    public static class Builder {

        private String name;
        private String idCard;
        private boolean sex;

        public Builder setIdCard(String idCard) {
            this.idCard = idCard;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSex(boolean sex) {
            this.sex = sex;
            return this;
        }

        public BuildDomain build() {
            return new BuildDomain(name,idCard,sex);
        }
    }
}
