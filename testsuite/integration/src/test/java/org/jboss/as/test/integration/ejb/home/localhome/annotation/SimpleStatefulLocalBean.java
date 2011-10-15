/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.test.integration.ejb.home.localhome.annotation;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalHome;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

import org.jboss.as.test.integration.ejb.home.localhome.SimpleLocalInterface;
import org.jboss.as.test.integration.ejb.home.localhome.SimpleStatefulLocalHome;

/**
 * @author Stuart Douglas
 */
@Stateful
@LocalHome(SimpleStatefulLocalHome.class)
@Local(SimpleLocalInterface.class)
public class SimpleStatefulLocalBean  {

    @Resource
    private SessionContext sessionContext;

    private String message;

    public void ejbCreateSimple(String message) {
        this.message = message;
    }

    public void ejbCreateComplex(String first, String second) {
        this.message = first + " " + second;
    }

    public String sayHello() {
        return message;
    }

    public String otherMethod() {
        return ((SimpleLocalInterface)sessionContext.getEJBLocalObject()).sayHello();
    }
}