package com.netcentric.brainery.yamldialog.touchui.coral.editconfig;

import static com.netcentric.brainery.yamldialog.common.TemplateItemProvider.get;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.NullAnyExporterItem;
import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Image;
import com.netcentric.brainery.yamldialog.common.editconfig.EditConfigBuilder;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class CoralEditConfigBuilder implements EditConfigBuilder {

	private List<TemplateItem> dropTargets = new ArrayList<>();

	@Override
	public AnyExportItem build() {
		if (dropTargets.isEmpty())
			return new NullAnyExporterItem();
		// instantiate and store each drop target
		StringJoiner items = new StringJoiner(Utils.BREAK_LINE);
		StringJoiner targets = new StringJoiner(Utils.BREAK_LINE);
		for (TemplateItem dropTarget : dropTargets) {
			if (dropTarget.isValid())
				targets.add(dropTarget.instanciate());
		}
		// create the required edit config templates
		TemplateItem ec = get(DialogType.EDITCONFIG, AnnotationType.EDITCONFIG);
		TemplateItem dp = get(DialogType.EDITCONFIG, AnnotationType.DROPTARGETS);
		TemplateItem ie = get(DialogType.EDITCONFIG, AnnotationType.INPLACEEDITING);
		// populate templates
		if (ec.isValid() && dp.isValid() && ie.isValid()) {
			dp.setValue("items", targets.toString());
			items.add(dp.instanciate());
			items.add(ie.instanciate());
			ec.setValue("items", items.toString());
			return new AnyExportItem(ec.instanciate(), ec.getKey());
		}
		return new NullAnyExporterItem();
	}

	@Override
	public void dropTarget(Image image) {
		TemplateItem dropTarget = get(DialogType.EDITCONFIG, AnnotationType.DROPTARGET);
		dropTarget.setValue("name", image.name);
		dropTargets.add(dropTarget);
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
