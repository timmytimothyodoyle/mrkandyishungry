<!DOCTYPE html>
<html>

<head>
	<jsp:include page="headlibs.jsp" />
</head>

<body>

    <div class="container">

		<jsp:include page="/components/navigation/navigation.jsp" />
		
		<jsp:include page="/components/configuration/configuration.jsp" />

		<jsp:include page="/components/editor/editor.jsp" />
        
        <jsp:include page="/components/console/console.jsp" />
        
		<jsp:include page="/components/output/output.jsp" />
    </div>
    
    <jsp:include page="footerlibs.jsp" />
</body>

</html>