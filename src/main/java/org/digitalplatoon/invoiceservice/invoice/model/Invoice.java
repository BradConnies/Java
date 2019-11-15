package org.digitalplatoon.invoiceservice.invoice.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "invoices")
public class Invoice {
    private long id;
    private String client;
    private long vatRate;
    private Date invoiceDate;

    public Invoice() { }

    public Invoice(String client, long vatRate, Date invoiceDate) {
        this.client = client;
        this.vatRate = vatRate;
        this.invoiceDate = invoiceDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() { return id;}
    public void setId(long id) {this.id = id;}

    @Column(name = "client", nullable = false)
    public String getClient() { return client;}
    private void setClient(String client) {this.client = client; }

    @Column(name = "vatRate", nullable = false)
    public long getVatRate() { return vatRate; }
    public void setVatRate(long vatRate) { this.vatRate = vatRate; }

    @Column(name = "invoiceDate", nullable = false)
    public Date getInvoiceDate() { return invoiceDate;}
    public void setInvoiceDate(Date invoiceDate) {this.invoiceDate = invoiceDate; }

    @Override
    public String toString() {
        return "Invoice [id=" + id + ",client=" + client + ",vatRate=" + vatRate + ",invoiceDate=" + invoiceDate + "]";
    }
}

