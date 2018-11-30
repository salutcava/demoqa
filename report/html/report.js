$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FORM_KNE_ASR.feature");
formatter.feature({
  "line": 5,
  "name": "KNE_ASR Form",
  "description": "",
  "id": "kne-asr-form",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@safetycube"
    },
    {
      "line": 2,
      "name": "@form"
    },
    {
      "line": 3,
      "name": "@kne"
    },
    {
      "line": 4,
      "name": "@kneform"
    }
  ]
});
formatter.before({
  "duration": 11670457395,
  "status": "passed"
});
formatter.background({
  "line": 7,
  "name": "A successful login",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 8,
  "name": "I enter my username \u0027safety-line-olivier\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I enter my password \u0027Bonjour123\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I click on the login button",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I check the page",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "click action",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "safety-line-olivier",
      "offset": 21
    }
  ],
  "location": "SafetyPortalLogin.i_enter_my_username(String)"
});
formatter.result({
  "duration": 1146287707,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bonjour123",
      "offset": 21
    }
  ],
  "location": "SafetyPortalLogin.i_enter_my_password(String)"
});
formatter.result({
  "duration": 869627731,
  "status": "passed"
});
formatter.match({
  "location": "SafetyPortalLogin.i_click_on_the_login_button()"
});
formatter.result({
  "duration": 97984029,
  "status": "passed"
});
formatter.match({
  "location": "SafetyPortalLogin.i_check_the_page()"
});
formatter.result({
  "duration": 1011077662,
  "status": "passed"
});
formatter.match({
  "location": "SafetyPortalLogin.action_link()"
});
formatter.result({
  "duration": 575520793,
  "error_message": "java.lang.UnsupportedOperationException: You may only deselect all options of a multi-select\r\n\tat org.openqa.selenium.support.ui.Select.deselectAll(Select.java:220)\r\n\tat SafetyPortalLogin.action_link(SafetyPortalLogin.java:81)\r\n\tat ✽.And click action(FORM_KNE_ASR.feature:12)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 14,
  "name": "Fill KNE_ASR form",
  "description": "",
  "id": "kne-asr-form;fill-kne-asr-form",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "the web browser is at the KNE_ASR form",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "the user fills the form",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "the user posts the form",
  "keyword": "Then "
});
formatter.match({
  "location": "FORM_KNE_ASR.open_form()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "FORM_KNE_ASR.fill_form()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "FORM_KNE_ASR.post_form()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 61136,
  "status": "passed"
});
});