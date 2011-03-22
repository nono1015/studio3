/**
 * Aptana Studio
 * Copyright (c) 2005-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the GNU Public License (GPL) v3 (with exceptions).
 * Please see the license.html included with this distribution for details.
 * Any modifications to this file must keep this entire header intact.
 */
package com.aptana.editor.yaml.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import com.aptana.editor.common.preferences.CommonEditorPreferencePage;
import com.aptana.editor.common.preferences.IPreferenceConstants;
import com.aptana.editor.yaml.YAMLEditor;
import com.aptana.editor.yaml.YAMLPlugin;

public class YAMLPreferencePage extends CommonEditorPreferencePage
{

	/**
	 * YamlPreferencePage
	 */

	public YAMLPreferencePage()
	{
		super();
		setDescription(Messages.YAMLPreferencePage_YAML_Page_Title);
		setPreferenceStore(YAMLPlugin.getDefault().getPreferenceStore());
	}

	@Override
	protected void createMarkOccurrenceOptions(Composite parent)
	{
	}

	@Override
	protected IEclipsePreferences getPluginPreferenceStore()
	{
		return new InstanceScope().getNode(YAMLPlugin.PLUGIN_ID);
	}

	@Override
	protected IPreferenceStore getChainedEditorPreferenceStore()
	{
		return YAMLEditor.getChainedPreferenceStore();
	}

	@Override
	protected void createAutoIndentOptions(Composite parent)
	{
		Composite autoIndentGroup = new Composite(parent, SWT.NONE);
		autoIndentGroup.setLayoutData(GridDataFactory.fillDefaults().span(3, 1).create());

		FieldEditor autoIndentTag = new BooleanFieldEditor(IPreferenceConstants.EDITOR_AUTO_INDENT,
				com.aptana.editor.common.preferences.Messages.CommonEditorPreferencePage_auto_indent_label,
				autoIndentGroup);
		addField(autoIndentTag);
	}

}
