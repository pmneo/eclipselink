/*******************************************************************************
 * Copyright (c) 1998, 2009 Oracle. All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 * Contributors:
 *     dclarke - Java Persistence 2.0 - Proposed Final Draft (March 13, 2009)
 *     		     Specification available from http://jcp.org/en/jsr/detail?id=317
 *
 * Java(TM) Persistence API, Version 2.0 - EARLY ACCESS
 * This is an implementation of an early-draft specification developed under the 
 * Java Community Process (JCP).  The code is untested and presumed not to be a  
 * compatible implementation of JSR 317: Java(TM) Persistence API, Version 2.0.   
 * We encourage you to migrate to an implementation of the Java(TM) Persistence 
 * API, Version 2.0 Specification that has been tested and verified to be compatible 
 * as soon as such an implementation is available, and we encourage you to retain 
 * this notice in any implementation of Java(TM) Persistence API, Version 2.0 
 * Specification that you distribute.
 ******************************************************************************/
package javax.persistence;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Is used to specify a mapped column for a persistent property or field.
 * If no Column annotation is specified, the default values are applied.
 * <p> Examples:
 *
 * <blockquote><pre>
 * Example 1:
 * &#064;Column(name="DESC", nullable=false, length=512)
 * public String getDescription() { return description; }
 *
 * Example 2:
 * &#064;Column(name="DESC",
 *         columnDefinition="CLOB NOT NULL",
 *         table="EMP_DETAIL")
 * &#064;Lob
 * public String getDescription() { return description; }
 *
 * Example 3:
 * &#064;Column(name="ORDER_COST", updatable=false, precision=12, scale=2)
 * public BigDecimal getCost() { return cost; }
 *
 * </pre></blockquote>
 *
 *
 * @since Java Persistence 1.0
 */ 
@Target({METHOD, FIELD}) 
@Retention(RUNTIME)
public @interface Column {

    /**
     * (Optional) The name of the column. Defaults to 
     * the property or field name.
     */
    String name() default "";

    /**
     * (Optional) Whether the property is a unique key.  This is a 
     * shortcut for the UniqueConstraint annotation at the table 
     * level and is useful for when the unique key constraint is 
     * only a single field. This constraint applies in addition 
     * to any constraint entailed by primary key mapping and 
     * to constraints specified at the table level.
     */
    boolean unique() default false;

    /**
     * (Optional) Whether the database column is nullable.
     */
    boolean nullable() default true;

    /**
     * (Optional) Whether the column is included in SQL INSERT 
     * statements generated by the persistence provider.
     */
    boolean insertable() default true;

    /**
     * (Optional) Whether the column is included in SQL UPDATE 
     * statements generated by the persistence provider.
     */
    boolean updatable() default true;

    /**
     * (Optional) The SQL fragment that is used when 
     * generating the DDL for the column.
     * <p> Defaults to the generated SQL to create a
     * column of the inferred type.
     */
    String columnDefinition() default "";

    /**
     * (Optional) The name of the table that contains the column. 
     * If absent the column is assumed to be in the primary table.
     */
    String table() default "";

    /**
     * (Optional) The column length. (Applies only if a
     * string-valued column is used.)
     */
    int length() default 255;

    /**
     * (Optional) The precision for a decimal (exact numeric) 
     * column. (Applies only if a decimal column is used.)
     * Value must be set by developer if used when generating 
     * the DDL for the column.
     */
    int precision() default 0;

    /**
     * (Optional) The scale for a decimal (exact numeric) column. 
     * (Applies only if a decimal column is used.)
     */
    int scale() default 0;
}
