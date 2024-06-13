package com.lab.vo.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@JsonPropertyOrder({"id", "author", "launchDate", "price", "title"})
public class BookVO extends RepresentationModel<BookVO>  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @JsonProperty("id")
    @Mapping("id")
    private UUID key;

    private String author;

    private Date launchDate;

    private Double price;

    private String title;

    public BookVO() {
    }

    public UUID getKey() {
        return key;
    }

    public void setKey(UUID key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BookVO bookVO = (BookVO) o;

        if (Double.compare(bookVO.price, price) != 0) return false;
        if (!key.equals(bookVO.key)) return false;
        if (!author.equals(bookVO.author)) return false;
        if (!launchDate.equals(bookVO.launchDate)) return false;
        return title.equals(bookVO.title);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + key.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + launchDate.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + title.hashCode();
        return result;
    }
}
