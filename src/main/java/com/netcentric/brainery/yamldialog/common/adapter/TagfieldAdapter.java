package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.adapter.AnyExportItemAdapter;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.NullAnyExporterItem;
import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Tagfield;
import com.netcentric.brainery.yamldialog.api.model.yaml.Tagfield.TagfieldType;
import com.netcentric.brainery.yamldialog.common.TemplateItemProvider;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class TagfieldAdapter implements AnyExportItemAdapter<Tagfield> {

	@Override
	public AnyExportItem adapt(Tagfield tagfield, DialogType type) {
		if (tagfield.isValid()) {
			TemplateItem template = TemplateItemProvider.get(type, getAnnotationType(tagfield));
			if (template.isValid()) {
				template.setValue("name", tagfield.name);
				template.setValue("empty", tagfield.empty);
				template.setValue("title", tagfield.title);
				template.setValue("description", tagfield.description);
				template.setBooleanValue("multiple", tagfield.multiple);
				return new AnyExportItem(template.instanciate(), template.getKey());
			}
		}
		return new NullAnyExporterItem();
	}

	private AnnotationType getAnnotationType(Tagfield tagfield) {
		return Utils.isEmpty(tagfield.type) || Utils.equals(tagfield.type, TagfieldType.AUTOCOMPLETE)
				? AnnotationType.TAGFIELD_LIST : AnnotationType.TAGFIELD;
	}

	@Override
	public boolean isValid() {
		return true;
	}

}