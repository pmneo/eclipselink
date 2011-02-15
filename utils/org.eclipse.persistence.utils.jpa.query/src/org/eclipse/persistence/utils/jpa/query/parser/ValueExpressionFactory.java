/*******************************************************************************
 * Copyright (c) 2006, 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available athttp://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle
 *
 ******************************************************************************/
package org.eclipse.persistence.utils.jpa.query.parser;

/**
 * This {@link ValueExpressionFactory} creates a new {@link ValueExpression}
 * when the portion of the query to parse starts with <b>VALUE</b>.
 *
 * @see ValueExpression
 *
 * @version 11.2.0
 * @since 11.2.0
 * @author Pascal Filion
 */
final class ValueExpressionFactory extends GeneralIdentificationExpressionFactory
{
	/**
	 * The unique identifier of this {@link ValueExpressionFactory}.
	 */
	static final String ID = Expression.VALUE;

	/**
	 * Creates a new <code>ValueExpressionFactory</code>.
	 */
	ValueExpressionFactory()
	{
		super(ID, Expression.VALUE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	AbstractExpression buildExpression(AbstractExpression parent)
	{
		return new ValueExpression(parent);
	}
}