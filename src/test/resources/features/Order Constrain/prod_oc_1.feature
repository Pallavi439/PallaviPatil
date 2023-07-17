@prod_1 @pranali.mulay@elastic.run
Feature: Prod OC 1

  Scenario: Create Customer tag from document tag doctype

    * user login to application by api
      | ${with-run-username} | ${with-run-password} |

    * user get "${wh2.oc.customer-1-title}" customer details by api
    * user generate random value "${wh2.oc.customer-1-title}" and store into session "customer-title"

    * user create "Document Tag" by api
      | tag_title | ${wh2.oc.customer-1-title} | /default-payload.json |
    * response status code should be 200

  Scenario: Create Parameterized document metric
    * user create "Parameterized Document Metric" by api
      | NA | {"title":"Automation prod_oc_1"} | /prod_oc_1_pdm.json |
    * response status code should be 200

    * get response "docs[0]" object and store into session "payload"

    * user hit get api call with query param
      | with-run | /api/method/frappe.client.get                  |
      | doctype  | Parameterized Document Metric                  |
      | filters  | {"title":"Automation prod_oc_1","docstatus":1} |

    * user hit post api call with form param if record not available
      | with-run | /api/method/frappe.desk.form.save.savedocs |
      | doc      | ${payload}                                 |
      | action   | Submit                                     |
    * response status code should be 200

    * user get details by frappe client get api with filters
      | Parameterized Document Metric | {"title":"Automation prod_oc_1"} |
    * get response "message.name" string attribute and store into session "prod_oc_1_pdm"

  Scenario: Create Constrain Group
    * user create "Constraint Group" by api
      | title | Automation Prod oc 1 CG1 | /prod_oc_1_CG1-default-payload.json |
    * response status code should be 200

    * user get details by frappe client get api with filters
      | Constraint Group | {"title":"Automation Prod oc 1 CG1"} |
    * get response "message.name" string attribute and store into session "prod_oc_1_CG1"

  Scenario: Create Constrain
    * user create "Constraint" by api
      | title | Automation Prod oc 1 C1 | /prod_oc_1_C1-default-payload.json |
    * response status code should be 200

  Scenario: Delete document tag
    * user delete doc type
      | Document Tag | ${Document Tag.name} |