/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_magazinedemo;

/**
 *
 * @author barry
 */
public class MagazineSubscription {

    private String subscriber;
    private String magazine;
    private int months;

    /**
     * @return the subscriber
     */
    public String getSubscriber() {
        return subscriber;
    }

    /**
     * @param subscriber the subscriber to set
     */
    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    /**
     * @return the magazine
     */
    public String getMagazine() {
        return magazine;
    }

    /**
     * @param magazine the magazine to set
     */
    public void setMagazine(String magazine) {
        this.magazine = magazine;
    }

    /**
     * @return the months
     */
    public int getMonths() {
        return months;
    }

    /**
     * @param months the months to set
     */
    public void setMonths(int months) {
        this.months = months;
    }
}
