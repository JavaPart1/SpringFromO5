package eu.noelvaes.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component("computer")
@Profile("spEL")
public class Computer {
    private LocalDate purchaseDate;
    private URL vendorUrl;
    private double price;
    private int memory;
    private String cpu;
    private int processors;
    private String ownerName;
    private String os;
    private List<String> features;

//    @Value("#{'02/05/2011 12:51'}")
//    public void setPurchaseDate(Date purchaseDate) {
//        this.purchaseDate = purchaseDate;
//    }
//
    @Value("#{T(java.time.LocalDate).of(2019,3,27)}")
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public URL getVendorUrl() {
        return vendorUrl;
    }

    public double getPrice() {
        return price;
    }

    public int getMemory() {
        return memory;
    }

    public String getCpu() {
        return cpu;
    }

    public int getProcessors() {
        return processors;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOs() {
        return os;
    }

    public List<String> getFeatures() {
        return features;
    }

    @Value("#{'https://www.google.be'}")
    public void setVendorUrl(URL vendorUrl) {
        this.vendorUrl = vendorUrl;
    }

    @Value("#{300.75}")
    public void setPrice(double price) {
        this.price = price;
    }

    @Value("#{500}")
    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Value("#{'Intel Celeron'}")
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Value("#{3}")
    public void setProcessors(int processors) {
        this.processors = processors;
    }

    @Value("#{'Develop Computer'}")
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Value("#{'Windows8'}")
    public void setOs(String os) {
        this.os = os;
    }

    @Value("#{{'Java', 'Intellij','MySql'}}")
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "purchaseDate=" + purchaseDate +
                ", vendorUrl=" + vendorUrl +
                ", price=" + price +
                ", memory=" + memory +
                ", cpu='" + cpu + '\'' +
                ", processors=" + processors +
                ", ownerName='" + ownerName + '\'' +
                ", os='" + os + '\'' +
                ", features=" + features +
                '}';
    }
}
