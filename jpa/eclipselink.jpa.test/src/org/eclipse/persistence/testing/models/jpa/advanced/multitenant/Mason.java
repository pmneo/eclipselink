/*
 * Copyright (c) 2012, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     14/05/2012-2.4 Guy Pelletier
//       - 376603: Provide for table per tenant support for multitenant applications
package org.eclipse.persistence.testing.models.jpa.advanced.multitenant;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyTemporal;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Multitenant;

import static javax.persistence.TemporalType.DATE;
import static org.eclipse.persistence.annotations.MultitenantType.TABLE_PER_TENANT;

@Entity
@Table(name="JPA_MASON")
@Multitenant(TABLE_PER_TENANT)
// Default to suffix.
public class Mason {
    public int id;
    public String name;
    public Trowel trowel;
    public Map<Date, String> awards;

    public Mason() {
        awards = new HashMap<Date, String>();
    }

    public void addAward(Date awardDate, String award) {
        awards.put(awardDate, award);
    }

    @ElementCollection
    @CollectionTable(
        name="JPA_MASON_AWARDS",
        joinColumns=@JoinColumn(name="MASON_ID"))
    @MapKeyColumn(name="AWARD_DATE")
    @MapKeyTemporal(DATE)
    @Column(name="AWARD")
    public Map<Date, String> getAwards() {
        return awards;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @OneToOne
    @JoinColumn(name="TROWEL_ID")
    public Trowel getTrowel() {
        return trowel;
    }

    public void setAwards(Map<Date, String> awards) {
        this.awards = awards;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrowel(Trowel trowel) {
        this.trowel = trowel;
    }
}
