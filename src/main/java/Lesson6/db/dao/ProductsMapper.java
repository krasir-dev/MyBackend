package db.dao;

import db.model.Products;
import db.model.ProductsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    long countByExample(ProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    int deleteByExample(ProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    int deleteByPrimaryKey(int id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    int insert(Products record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    int insertSelective(Products record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    List<Products> selectByExample(ProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    Products selectByPrimaryKey(int id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    int updateByExampleSelective(@Param("record") Products record, @Param("example") ProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    int updateByExample(@Param("record") Products record, @Param("example") ProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    int updateByPrimaryKeySelective(Products record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sun Oct 02 13:45:55 IRKT 2022
     */
    int updateByPrimaryKey(Products record);
}