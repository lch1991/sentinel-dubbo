package com.sentinel.dao.dto;

import javax.persistence.*;

@Table(name = "t_storage")
public class TstorageDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "commodity_code")
    private String commodityCode;

    private String name;

    private Integer count;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return commodity_code
     */
    public String getCommodityCode() {
        return commodityCode;
    }

    /**
     * @param commodityCode
     */
    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode == null ? null : commodityCode.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}