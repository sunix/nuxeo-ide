var operationParameters = {
	operationId : 'Feed.Provider',
    operationParams : {
         limit : 4
    },
    entityType : 'blob',
    operationContext : {},
    operationCallback : oprationCallbackHandler
};

gadgets.util.registerOnLoadHandler(function(){
	alert("gadget loaded");
	//doAutomationRequest(operationParameters); // invoke operation when gadget is loaded
});


function oprationCallbackHandler(response, operationParameters) { // called after operation invocation

}