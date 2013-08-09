Liferay.Service.register("Liferay.Service.opengr", "gr.open.marketplace.service", "admin-allowed-ips-config-portlet");

Liferay.Service.registerClass(
	Liferay.Service.opengr, "AdminIPValidationData",
	{
		getAllowedAddressesList: true,
		getRedirectUrl: true
	}
);