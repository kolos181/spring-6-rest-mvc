package guru.springframework.spring6restmvc.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Customer {
    private String customerName;
    private UUID id;
    private String version;
    private Date createdDate;
    private Date lastModifiedDate;

    public Customer(CustomerBuilder customerBuilder) {
        this.customerName = customerBuilder.customerName;
        this.id = customerBuilder.id;
        this.version = customerBuilder.version;
        this.createdDate = customerBuilder.createdDate;
        this.lastModifiedDate = customerBuilder.lastModifiedDate;
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public static class CustomerBuilder {
        private String customerName;
        private UUID id;
        private String version;
        private Date createdDate;
        private Date lastModifiedDate;

        CustomerBuilder() {
        }

        public CustomerBuilder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public CustomerBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder version(String version) {
            this.version = version;
            return this;
        }

        public CustomerBuilder createdDate(Date createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public CustomerBuilder lastModifiedDate(Date lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

        public String toString() {
            return "Customer.CustomerBuilder(customerName=" + this.customerName + ", id=" + this.id + ", version=" + this.version + ", createdDate=" + this.createdDate + ", lastModifiedDate=" + this.lastModifiedDate + ")";
        }
    }
}
