/*******************************************************************************
 * Copyright (c) 1998, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.testing.models.bigbad;

import org.eclipse.persistence.tools.schemaframework.*;

/**
 * This class was generated by the TopLink table creator generator.
 * It stores the meta-data (tables) that define the database schema.
 * @see org.eclipse.persistence.sessions.factories.TableCreatorClassGenerator
 */
public class BigBadTableCreator extends TableCreator {

    public BigBadTableCreator() {
        setName("BigBad");

        addTableDefinition(buildBIG_BAD_OBJTable());
        addTableDefinition(buildBIG_BAD_DATATable());
    }

    public TableDefinition buildBIG_BAD_OBJTable() {
        TableDefinition table = new TableDefinition();
        table.setName("BIG_BAD_OBJ");

        // ids
        for (int index = 0; index < 10; index++) {
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            FieldDefinition field = new FieldDefinition();
            field.setName("ID" + indexString);
            field.setTypeName("NUMERIC");
            field.setIsPrimaryKey(true);
            field.setShouldAllowNull(false);
            table.addField(field);
        }
        // strings
        for (int index = 0; index < 20; index++) {
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            FieldDefinition field = new FieldDefinition();
            field.setName("STRING_DATA" + indexString);
            field.setTypeName("VARCHAR");
            field.setSize(100);
            field.setShouldAllowNull(true);
            table.addField(field);
        }
        // calendar
        for (int index = 0; index < 10; index++) {
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            FieldDefinition field = new FieldDefinition();
            field.setName("CALENDAR_DATA" + indexString);
            field.setTypeName("TIMESTAMP");
            field.setShouldAllowNull(true);
            table.addField(field);
        }
        // date
        for (int index = 0; index < 10; index++) {
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            FieldDefinition field = new FieldDefinition();
            field.setName("DATE_DATA" + indexString);
            field.setTypeName("DATE");
            field.setShouldAllowNull(true);
            table.addField(field);
        }
        // time
        for (int index = 0; index < 10; index++) {
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            FieldDefinition field = new FieldDefinition();
            field.setName("TIME_DATA" + indexString);
            field.setTypeName("TIME");
            field.setShouldAllowNull(true);
            table.addField(field);
        }
        // timestamp
        for (int index = 0; index < 10; index++) {
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            FieldDefinition field = new FieldDefinition();
            field.setName("TIMESTAMP_DATA" + indexString);
            field.setTypeName("TIMESTAMP");
            field.setShouldAllowNull(true);
            table.addField(field);
        }
        // largestring
        for (int index = 0; index < 3; index++) {
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            FieldDefinition field = new FieldDefinition();
            field.setName("LSTRING_DATA" + indexString);
            field.setTypeName("CLOB");
            field.setShouldAllowNull(true);
            table.addField(field);
        }
        // blob	
        FieldDefinition field = new FieldDefinition();
        field.setName("BLOB_DATA");
        field.setTypeName("BLOB");
        field.setShouldAllowNull(true);
        table.addField(field);
        // serialized blob
        field = new FieldDefinition();
        field.setName("SER_DATA");
        field.setTypeName("BLOB");
        field.setShouldAllowNull(true);
        table.addField(field);
        // numbers
        field = new FieldDefinition();
        field.setName("NUM_DATA01");
        field.setTypeName("NUMERIC");
        field.setShouldAllowNull(true);
        table.addField(field);
        field = new FieldDefinition();
        field.setName("NUM_DATA02");
        field.setTypeName("NUMERIC");
        field.setShouldAllowNull(true);
        table.addField(field);

        // aggregates
        for (int index = 0; index < 3; index++) {
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            field = new FieldDefinition();
            field.setName("AGG_STRING" + indexString);
            field.setTypeName("VARCHAR");
            field.setShouldAllowNull(true);
            table.addField(field);
            field = new FieldDefinition();
            field.setName("AGG_NUM" + indexString);
            field.setTypeName("NUMERIC");
            field.setShouldAllowNull(true);
            table.addField(field);
        }
        // 1-1
        for (int index = 0; index < 3; index++) {
            String indexString = String.valueOf(index + 1);
            if (indexString.length() == 1) {
                indexString = "0" + indexString;
            }
            field = new FieldDefinition();
            field.setName("REF_FK" + indexString);
            field.setTypeName("NUMERIC");
            field.setShouldAllowNull(true);
            table.addField(field);
        }

        return table;
    }

    public TableDefinition buildBIG_BAD_DATATable() {
        TableDefinition table = new TableDefinition();
        table.setName("BIG_BAD_DATA");

        FieldDefinition field = new FieldDefinition();
        field.setName("ID");
        field.setTypeName("NUMERIC");
        field.setIsPrimaryKey(true);
        field.setUnique(false);
        field.setShouldAllowNull(false);
        table.addField(field);

        field = new FieldDefinition();
        field.setName("DATA");
        field.setTypeName("VARCHAR");
        field.setSize(100);
        field.setShouldAllowNull(true);
        table.addField(field);

        return table;
    }

}
