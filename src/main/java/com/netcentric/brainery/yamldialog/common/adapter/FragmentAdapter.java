package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.NullAnyExporterItem;
import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Fragment;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class FragmentAdapter extends TemplateAdapter<Fragment> {

	@Override
	protected AnyExportItem apply(Fragment item, TemplateItem template) {
		System.out.println("ACACACACACJHSGHJAGSDJHGSDJHAGSDJHAGDS");
		return new NullAnyExporterItem();
	}

}