
    
 $(document).ready(function(){
      var date_input=$('input[name="birth_entry_form1"]'); //our date input has the name "date"
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true
      };
      date_input.datepicker(options);
    });
    
    
$(document).ready(function(){
      var date_input=$('input[name="production_entry_form2"]'); //our date input has the name "date"
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true
      };
      date_input.datepicker(options);
    });
    
    
$(document).ready(function(){
      var date_input=$('input[name="lastMaintain_entry_form3"]'); //our date input has the name "date"
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true
      };
      date_input.datepicker(options);
    });
    
    

    
function consultOddorDescription() {
    
    const prompt = "Describe en menos de 100 palabras, a gran detalle y en español que caracteriza al olor de software que se llama: " + document.getElementById("odorName_entry_form5").value;

    const apiKey = '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'; // Reemplaza con tu clave de API de OpenAI
    const url = 'https://api.openai.com/v1/engines/text-davinci-002/completions';

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${apiKey}`
        },
        body: JSON.stringify({
            prompt: prompt,
            max_tokens: 150 // Número máximo de tokens en la respuesta
        })
    })
    .then(response => response.json())
    .then(data => {
        const respuesta = data.choices[0].text.replace(/\n/g, '');; // Extrae la respuesta del JSON
        document.getElementById("description_entry_form5").value = respuesta;
       
    })
    .catch(error => {
        console.error('Error al consultar GPT-3:', error);
    });
}



function consultRefactorDescription() {
    
    const prompt = "Describe en menos de 100 palabras, a gran detalle y en español que caracteriza al método de refactorización de software que se llama: " + document.getElementById("refacorName_entry_form6").value;
    console.log(prompt);
    const apiKey = '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'; // Reemplaza con tu clave de API de OpenAI
    const url = 'https://api.openai.com/v1/engines/text-davinci-002/completions';

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${apiKey}`
        },
        body: JSON.stringify({
            prompt: prompt,
            max_tokens: 150 // Número máximo de tokens en la respuesta
        })
    })
    .then(response => response.json())
    .then(data => {
        const respuesta = data.choices[0].text.replace(/\n/g, '');; // Extrae la respuesta del JSON
        document.getElementById("description_entry_form6").value = respuesta;
       
    })
    .catch(error => {
        console.error('Error al consultar GPT-3:', error);
    });
}

function findMethodByComplex(){
    const consultType = "getmethod1";
    const appname = document.getElementById("app_selectmethod1").value;
    // const methodname = document.getElementById("method_selectmethod1").value;
    const methodname = "";

    
    const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;

    fetch(url)
      .then(response => {
        if (!response.ok) {
          throw new Error('La solicitud no fue exitosa');
        }
        return response.text();
      })
      .then(data => {
          
            const selectElement = document.getElementById("method_selectmethod1");
            var jsonresult = JSON.parse(data);

           
            const valores = jsonresult.methodlist.split(",");
           
            while (selectElement.firstChild) {
                selectElement.removeChild(selectElement.firstChild);
            }
            const emptyoption = document.createElement("option");
            emptyoption.text = "";
            emptyoption.value = "";
            selectElement.appendChild(emptyoption);
            // Itera sobre los valores y agrega opciones al select
            valores.forEach((valor) => {
                const option = document.createElement("option");
                option.text = valor;
                option.value = valor;
                selectElement.appendChild(option);
            });

      })
      .catch(error => {
        console.error('Error:', error);
      });
    }
    
    
    function findmethodinfo1(){
    
        const consultType = "getmethod1";
        const appname = "";
        const methodname = document.getElementById("method_selectmethod1").value;


        const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;

        fetch(url)
          .then(response => {
            if (!response.ok) {
              throw new Error('La solicitud no fue exitosa');
            }
            return response.text();
          })
          .then(data => {

                var textarea = document.getElementById("textareamethod1");
                
                var jsonresult = JSON.parse(data);
                
                textarea.value = jsonresult.methodinfo;


          })
          .catch(error => {
            console.error('Error:', error);
          });
    }
    
    
    
    function findMethodByComplex2(){
    const consultType = "getmethod2";
    const appname = document.getElementById("app_selectmethod2").value;
    // const methodname = document.getElementById("method_selectmethod1").value;
    const methodname = "";

    
    const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;

    fetch(url)
      .then(response => {
        if (!response.ok) {
          throw new Error('La solicitud no fue exitosa');
        }
        return response.text();
      })
      .then(data => {
          
            const selectElement = document.getElementById("method_selectmethod2");
            var jsonresult = JSON.parse(data);

           
            const valores = jsonresult.methodlist.split(",");
           
            while (selectElement.firstChild) {
                selectElement.removeChild(selectElement.firstChild);
            }
            const emptyoption = document.createElement("option");
            emptyoption.text = "";
            emptyoption.value = "";
            selectElement.appendChild(emptyoption);
            // Itera sobre los valores y agrega opciones al select
            valores.forEach((valor) => {
                const option = document.createElement("option");
                option.text = valor;
                option.value = valor;
                selectElement.appendChild(option);
            });

      })
      .catch(error => {
        console.error('Error:', error);
      });
    }
    
    
    function findmethodinfo2(){
    
        const consultType = "getmethod2";
        const appname = "";
        const methodname = document.getElementById("method_selectmethod2").value;


        const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;

        fetch(url)
          .then(response => {
            if (!response.ok) {
              throw new Error('La solicitud no fue exitosa');
            }
            return response.text();
          })
          .then(data => {

                var textarea = document.getElementById("textareamethod2");
                
                var jsonresult = JSON.parse(data);
                
                textarea.value = jsonresult.methodinfo;


          })
          .catch(error => {
            console.error('Error:', error);
          });
    }
    
    
    
        function findMethodByComplex3(){
            const consultType = "getmethod3";
            const appname = document.getElementById("app_selectmethod3").value;
            // const methodname = document.getElementById("method_selectmethod1").value;
            const methodname = "";


            const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;

            fetch(url)
              .then(response => {
                if (!response.ok) {
                  throw new Error('La solicitud no fue exitosa');
                }
                return response.text();
              })
              .then(data => {

                    const selectElement = document.getElementById("method_selectmethod3");
                    var jsonresult = JSON.parse(data);


                    const valores = jsonresult.methodlist.split(",");

                    while (selectElement.firstChild) {
                        selectElement.removeChild(selectElement.firstChild);
                    }
                    const emptyoption = document.createElement("option");
                    emptyoption.text = "";
                    emptyoption.value = "";
                    selectElement.appendChild(emptyoption);
                    // Itera sobre los valores y agrega opciones al select
                    valores.forEach((valor) => {
                        const option = document.createElement("option");
                        option.text = valor;
                        option.value = valor;
                        selectElement.appendChild(option);
                    });

              })
              .catch(error => {
                console.error('Error:', error);
              });
    }
    
    
    function findmethodinfo3(){
    
        const consultType = "getmethod3";
        const appname = "";
        const methodname = document.getElementById("method_selectmethod3").value;


        const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;

        fetch(url)
          .then(response => {
            if (!response.ok) {
              throw new Error('La solicitud no fue exitosa');
            }
            return response.text();
          })
          .then(data => {

                var textarea = document.getElementById("textareamethod3");
                
                var jsonresult = JSON.parse(data);
                
                textarea.value = jsonresult.methodinfo;


          })
          .catch(error => {
            console.error('Error:', error);
          });
    }
    
    
        function findMethodByComplex4(){
    
            const consultType = "getmethod4";
            const appname = document.getElementById("app_selectmethod4").value;
            
            
            // const methodname = document.getElementById("method_selectmethod1").value;
            const methodname = "";
            
            const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;
           
            
            fetch(url)
              .then(response => {
                if (!response.ok) {
                  throw new Error('La solicitud no fue exitosa');
                }
                return response.text();
              })
              .then(data => {

                    const selectElement = document.getElementById("method_selectmethod4");
                    var jsonresult = JSON.parse(data);
                  

                    const valores = jsonresult.methodlist.split(",");

                    while (selectElement.firstChild) {
                        selectElement.removeChild(selectElement.firstChild);
                    }
                    const emptyoption = document.createElement("option");
                    emptyoption.text = "";
                    emptyoption.value = "";
                    selectElement.appendChild(emptyoption);
                    // Itera sobre los valores y agrega opciones al select
                    valores.forEach((valor) => {
                        const option = document.createElement("option");
                        option.text = valor;
                        option.value = valor;
                        selectElement.appendChild(option);
                    });

              })
              .catch(error => {
                console.error('Error:', error);
              });
    }
    
    
    function findmethodinfo4(){
    
        const consultType = "getmethod4";
        const appname = "";
        const methodname = document.getElementById("method_selectmethod4").value;


        const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;

        fetch(url)
          .then(response => {
            if (!response.ok) {
              throw new Error('La solicitud no fue exitosa');
            }
            return response.text();
          })
          .then(data => {

                var textarea = document.getElementById("textareamethod4");
                
                var jsonresult = JSON.parse(data);
                
                textarea.value = jsonresult.methodinfo;


          })
          .catch(error => {
            console.error('Error:', error);
          });
    }
    
    
        function findMethodByComplex5(){
    
            const consultType = "getmethod5";
            const appname = document.getElementById("app_selectmethod5").value;
            
            // const methodname = document.getElementById("method_selectmethod1").value;
            const methodname = "";

            
            const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;
          
            
            fetch(url)
              .then(response => {
                if (!response.ok) {
                  throw new Error('La solicitud no fue exitosa');
                }
                return response.text();
              })
              .then(data => {

                    const selectElement = document.getElementById("method_selectmethod5");
                    var jsonresult = JSON.parse(data);
                

                    const valores = jsonresult.methodlist.split(",");

                    while (selectElement.firstChild) {
                        selectElement.removeChild(selectElement.firstChild);
                    }
                    const emptyoption = document.createElement("option");
                    emptyoption.text = "";
                    emptyoption.value = "";
                    selectElement.appendChild(emptyoption);
                    // Itera sobre los valores y agrega opciones al select
                    valores.forEach((valor) => {
                        const option = document.createElement("option");
                        option.text = valor;
                        option.value = valor;
                        selectElement.appendChild(option);
                    });

              })
              .catch(error => {
                console.error('Error:', error);
              });
    }
    
    
    function findmethodinfo5(){
    
        const consultType = "getmethod5";
        const appname = "";
        const methodname = document.getElementById("method_selectmethod5").value;


        const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;

        fetch(url)
          .then(response => {
            if (!response.ok) {
              throw new Error('La solicitud no fue exitosa');
            }
            return response.text();
          })
          .then(data => {

                var textarea = document.getElementById("textareamethod5");
                
                var jsonresult = JSON.parse(data);
                
                textarea.value = jsonresult.methodinfo;


          })
          .catch(error => {
            console.error('Error:', error);
          });
    }    

        function findMethodByComplex6(){
    
            const consultType = "getmethod6";
            const appname = document.getElementById("app_selectmethod6").value;
            
            // const methodname = document.getElementById("method_selectmethod1").value;
            const methodname = "";
            
      
            
            
            const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;
   
            
            fetch(url)
              .then(response => {
                if (!response.ok) {
                  throw new Error('La solicitud no fue exitosa');
                }
                return response.text();
              })
              .then(data => {

                    const selectElement = document.getElementById("method_selectmethod6");
                    var jsonresult = JSON.parse(data);
            

                    const valores = jsonresult.methodlist.split(",");

                    while (selectElement.firstChild) {
                        selectElement.removeChild(selectElement.firstChild);
                    }
                    const emptyoption = document.createElement("option");
                    emptyoption.text = "";
                    emptyoption.value = "";
                    selectElement.appendChild(emptyoption);
                    // Itera sobre los valores y agrega opciones al select
                    valores.forEach((valor) => {
                        const option = document.createElement("option");
                        option.text = valor;
                        option.value = valor;
                        selectElement.appendChild(option);
                    });

              })
              .catch(error => {
                console.error('Error:', error);
              });
    }
    
    
    function findmethodinfo6(){
    
        const consultType = "getmethod6";
        const appname = "";
        const methodname = document.getElementById("method_selectmethod6").value;


        const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;

        fetch(url)
          .then(response => {
            if (!response.ok) {
              throw new Error('La solicitud no fue exitosa');
            }
            return response.text();
          })
          .then(data => {

                var textarea = document.getElementById("textareamethod6");
                
                var jsonresult = JSON.parse(data);
                
                textarea.value = jsonresult.methodinfo;


          })
          .catch(error => {
            console.error('Error:', error);
          });
    }    


    function findmethodinfo7(){
    
        const consultType = "getmethod7";
        const appname = "";
        const methodname = document.getElementById("app_selectmethod7").value;

        
        const url = `ConsultEngine?appname=${codifystring(appname)}&methodname=${codifystring(methodname)}&consultType=${codifystring(consultType)}`;

        fetch(url)
          .then(response => {
            if (!response.ok) {
              throw new Error('La solicitud no fue exitosa');
            }
            return response.text();
          })
          .then(data => {

                var textarea = document.getElementById("textareamethod7");
                
                var jsonresult = JSON.parse(data);
                
                textarea.value = jsonresult.methodinfo;


          })
          .catch(error => {
            console.error('Error:', error);
          });
    }      
    
    
function codifystring(cadena) {
    // Reemplazar espacios en blanco por %20
    cadena = cadena.replace(/ /g, '%20');

    // Reemplazar + por %2B
    cadena = cadena.replace(/\+/g, '%2B');

    // Reemplazar & por %26
    cadena = cadena.replace(/&/g, '%26');

    // Reemplazar = por %3D
    cadena = cadena.replace(/=/g, '%3D');

    // Reemplazar - por %2D
    cadena = cadena.replace(/-/g, '%2D');

    // Reemplazar * por %2A
    cadena = cadena.replace(/\*/g, '%2A');

    // Reemplazar ? por %3F
    cadena = cadena.replace(/\?/g, '%3F');

    // Reemplazar # por %23
    cadena = cadena.replace(/#/g, '%23');

    // Otras sustituciones personalizadas se pueden agregar según sea necesario

  return cadena;
}

function showReportXML() {

    document.getElementById('labelXML').style.display = 'block';
    document.getElementById('textareamethod91').style.display = 'block';
    document.getElementById('labelCSV').style.display = 'none';
    document.getElementById('textareamethod92').style.display = 'none';
    document.getElementById('labelJSON').style.display = 'none';
    document.getElementById('textareamethod93').style.display = 'none';
}

function showReportCSV() {

    document.getElementById('labelXML').style.display = 'none';
    document.getElementById('textareamethod91').style.display = 'none';
    document.getElementById('labelCSV').style.display = 'block';
    document.getElementById('textareamethod92').style.display = 'block';
    document.getElementById('labelJSON').style.display = 'none';
    document.getElementById('textareamethod93').style.display = 'none';
}

function showReportJSON() {

    document.getElementById('labelXML').style.display = 'none';
    document.getElementById('textareamethod91').style.display = 'none';
    document.getElementById('labelCSV').style.display = 'none';
    document.getElementById('textareamethod92').style.display = 'none';
    document.getElementById('labelJSON').style.display = 'block';
    document.getElementById('textareamethod93').style.display = 'block';
}