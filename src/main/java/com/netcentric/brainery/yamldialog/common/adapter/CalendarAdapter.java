package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Calendar;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class CalendarAdapter extends TemplateAdapter<Calendar> {

	@Override
	protected AnyExportItem apply(Calendar calendar, TemplateItem template) {
		template.setValue("name", calendar.name);
		template.setValue("title", calendar.title);
		template.setValue("value", calendar.value);
		template.setValue("empty", calendar.empty);
		template.setValue("format", calendar.format);
		template.setValue("mindate", calendar.mindate);
		template.setValue("maxdate", calendar.maxdate);
		template.setValue("validation", calendar.validation);
		template.setValue("description", calendar.description);
		template.setBooleanValue("timezone", calendar.timezone);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}
