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
 * The <b>HAVING</b> construct enables conditions to be specified that further
 * restrict the query result as restrictions upon the groups.
 * <p>
 * <div nowrap><b>BNF:</b> <code>having_clause ::= HAVING conditional_expression</code><p>
 *
 * @version 11.2.0
 * @since 11.0.0
 * @author Pascal Filion
 */
public final class HavingClause extends AbstractConditionalClause
{
	/**
	 * Creates a new <code>HavingClause</code>.
	 *
	 * @param parent The parent of this expression
	 */
	HavingClause(AbstractExpression parent)
	{
		super(parent, HAVING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void accept(ExpressionVisitor visitor)
	{
		visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	JPQLQueryBNF getQueryBNF()
	{
		return queryBNF(WhereClauseBNF.ID);
	}
}