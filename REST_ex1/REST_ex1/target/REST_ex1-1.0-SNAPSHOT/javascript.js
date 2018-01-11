/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        var mainQuote = document.getElementById("mainQuote");
        var btnNew = document.getElementById("btnNew");
        var quoteAdd = document.getElementById("quoteAdd");
        var quoteEdit = document.getElementById("quoteEdit");
        var quoteDelete = document.getElementById("quoteDelete");


        
        btnNew.onclick = function(){
            getRandomQuote();
        };
        
        quoteAdd.onclick = function (){
            createQuote();
        };
        
        quoteEdit.onclick = function(){
            editQuote();
        };
        
        quoteDelete.onclick = function(){
            deleteQuote();
        };
        
        var getRandomQuote = function(){
            fetch("api/quote/random", 
            {method: "get"})
            .then(function(response){
                return response.text();
            }).then(function(text){
                var quoteObject = JSON.parse(text);
                mainQuote.innerHTML = quoteObject.quote;
            });
        };
        
    function createQuote(){   
        
        var quoteText = {
            text: document.getElementById("quoteText").value
        };
    
        fetch("api/quote", {
            method: "post",
            body: JSON.stringify(quoteText),
            headers: new Headers({'content-type': 'application/json'})
            })
                .then(function (response){
                if (!response.ok){
                    var error = new Error();
                    error.response = response;
                    throw error;
                }
                return response.json();
            })
            .then(function (json) {
                alert("Citatet '" + quoteText.text.valueOf() + "' er blevet tilføjet!");
            })
                .catch(function (error) {
                alert("Quote blev ikke tilføjet!");
            });
            
    }
            
    function editQuote(){
        var quoteText = {
            id: document.getElementById("idEdit"),
            text: document.getElementById("quoteText").value
        };

    fetch("api/quote",{
        method: "put",
        body: JSON.stringify(quoteText),
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response){
                if (!response.ok){
                    var error = new Error();
                    error.response = response;
                    throw error;
                }
                return response.json();
            })
            .then(function (json){
                alert("Citat blev ændret!");
        
                PersonsRefresh();
            })
            .catch(function (error){
                alert("Citatet blev ikke ændret!");
            });
}   

function deleteQuote(){
    deleteQuoteID(document.getElementById("idDelete").value);
}

function deleteQuoteID(id){
    fetch("api/quote/" + id,{
        method: "delete",
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response){
                if (!response.ok){
                    var error = new Error();
                    error.response = response;
                    throw error;
                }
                return response.json();
            })
            .then(function (json){
                alert("Citatet blev fjernet!");
        
                PersonsRefresh();
            })
            .catch(function (error){
                alert("Citat blev desværre ikke fjernet, kammerat!");
            });
}
        
    