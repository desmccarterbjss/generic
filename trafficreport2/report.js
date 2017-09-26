$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("captureattributes.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: michael.umenyiora@bjss.com"
    },
    {
      "line": 2,
      "value": "#Feature: Capture Attributes."
    },
    {
      "line": 3,
      "value": "#Scenario: Capture User Id."
    },
    {
      "line": 4,
      "value": "#Scenario: Capture Date and Time"
    },
    {
      "line": 5,
      "value": "#Scenario: Attribute Set - Payment"
    },
    {
      "line": 6,
      "value": "#Scenario: Attribute Set - Sub Mail Type"
    },
    {
      "line": 7,
      "value": "#Scenario: Attribute Set - Mail Item Class"
    },
    {
      "line": 8,
      "value": "#Scenario: Attribute Set- Container Type (Barcode Unavailable)"
    },
    {
      "line": 9,
      "value": "#Scenario: Attribute Set- Container Type (Barcode Available)"
    },
    {
      "line": 10,
      "value": "#Scenario: Validate Entry Attribute Set"
    },
    {
      "line": 11,
      "value": "#Scenario: Validate Attribute Set"
    },
    {
      "line": 12,
      "value": "#Scenario: Derive ACF from entered Attributes"
    },
    {
      "line": 13,
      "value": "#Scenario: Display ACF Count"
    },
    {
      "line": 14,
      "value": "#"
    }
  ],
  "line": 16,
  "name": "Capture Attributes",
  "description": "",
  "id": "capture-attributes",
  "keyword": "Feature",
  "tags": [
    {
      "line": 15,
      "name": "@captureattributes"
    }
  ]
});
formatter.scenarioOutline({
  "line": 41,
  "name": "Shift Details full entry",
  "description": "",
  "id": "capture-attributes;shift-details-full-entry",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 40,
      "name": "@PDAPTT-256"
    },
    {
      "line": 40,
      "name": "@sprint1"
    },
    {
      "line": 40,
      "name": "@regression"
    }
  ]
});
formatter.step({
  "line": 42,
  "name": "The user has logged on with their username \"\u003cuser ID\u003e\" and pin \"\u003cpin\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "The user is on the shift details page",
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "The user selects full shift details",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "The confirm button should be enabled",
  "keyword": "Then "
});
formatter.examples({
  "line": 47,
  "name": "login data",
  "description": "",
  "id": "capture-attributes;shift-details-full-entry;login-data",
  "rows": [
    {
      "cells": [
        "user ID",
        "pin"
      ],
      "line": 48,
      "id": "capture-attributes;shift-details-full-entry;login-data;1"
    },
    {
      "cells": [
        "michael.umenyiora",
        "5678"
      ],
      "line": 49,
      "id": "capture-attributes;shift-details-full-entry;login-data;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 16663546865,
  "status": "passed"
});
formatter.scenario({
  "line": 49,
  "name": "Shift Details full entry",
  "description": "",
  "id": "capture-attributes;shift-details-full-entry;login-data;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 40,
      "name": "@PDAPTT-256"
    },
    {
      "line": 40,
      "name": "@regression"
    },
    {
      "line": 40,
      "name": "@sprint1"
    },
    {
      "line": 15,
      "name": "@captureattributes"
    }
  ]
});
formatter.step({
  "line": 42,
  "name": "The user has logged on with their username \"michael.umenyiora\" and pin \"5678\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "The user is on the shift details page",
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "The user selects full shift details",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "The confirm button should be enabled",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "michael.umenyiora",
      "offset": 44
    },
    {
      "val": "5678",
      "offset": 72
    }
  ],
  "location": "TrafficStepDef.the_user_has_logged_on_with_their_username_and(String,String)"
});
formatter.result({
  "duration": 5562344692,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.the_user_is_on_the_shift_details_page()"
});
formatter.result({
  "duration": 136902819161,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.the_user_selects_full_shift_details()"
});
formatter.result({
  "duration": 4736241383,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.the_confirm_button_should_be_enabled()"
});
formatter.result({
  "duration": 892843457,
  "status": "passed"
});
formatter.after({
  "duration": 67951,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 52,
  "name": "Shift Details partial entry",
  "description": "",
  "id": "capture-attributes;shift-details-partial-entry",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 51,
      "name": "@PDAPTT-256"
    },
    {
      "line": 51,
      "name": "@sprint1"
    },
    {
      "line": 51,
      "name": "@regression"
    }
  ]
});
formatter.step({
  "line": 53,
  "name": "The user has logged on with their username \"\u003cuser ID\u003e\" and pin \"\u003cpin\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "The user is on the shift details page",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "The user partially selects shift details",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "The confirm button should be disabled",
  "keyword": "Then "
});
formatter.examples({
  "line": 58,
  "name": "login data",
  "description": "",
  "id": "capture-attributes;shift-details-partial-entry;login-data",
  "rows": [
    {
      "cells": [
        "user ID",
        "pin"
      ],
      "line": 59,
      "id": "capture-attributes;shift-details-partial-entry;login-data;1"
    },
    {
      "cells": [
        "michael.umenyiora",
        "5678"
      ],
      "line": 60,
      "id": "capture-attributes;shift-details-partial-entry;login-data;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 415605,
  "status": "passed"
});
formatter.scenario({
  "line": 60,
  "name": "Shift Details partial entry",
  "description": "",
  "id": "capture-attributes;shift-details-partial-entry;login-data;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 51,
      "name": "@PDAPTT-256"
    },
    {
      "line": 51,
      "name": "@regression"
    },
    {
      "line": 51,
      "name": "@sprint1"
    },
    {
      "line": 15,
      "name": "@captureattributes"
    }
  ]
});
formatter.step({
  "line": 53,
  "name": "The user has logged on with their username \"michael.umenyiora\" and pin \"5678\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "The user is on the shift details page",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "The user partially selects shift details",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "The confirm button should be disabled",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "michael.umenyiora",
      "offset": 44
    },
    {
      "val": "5678",
      "offset": 72
    }
  ],
  "location": "TrafficStepDef.the_user_has_logged_on_with_their_username_and(String,String)"
});
formatter.result({
  "duration": 33523440198,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.the_user_is_on_the_shift_details_page()"
});
formatter.result({
  "duration": 37373505975,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.the_user_partially_selects_shift_details()"
});
formatter.result({
  "duration": 2457632395,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.the_confirm_button_should_be_disabled()"
});
formatter.result({
  "duration": 912794469,
  "status": "passed"
});
formatter.after({
  "duration": 36741,
  "status": "passed"
});
formatter.uri("userauthentication.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: michael.umenyiora@bjss.com"
    },
    {
      "line": 2,
      "value": "#Feature: User Authentication."
    },
    {
      "line": 3,
      "value": "#Scenario: User Login"
    },
    {
      "line": 4,
      "value": "#Scenario: Pre-login positive validation"
    },
    {
      "line": 5,
      "value": "#Scenario: Pre-login negative validation"
    },
    {
      "line": 6,
      "value": "#Scenario: User Login successful"
    },
    {
      "line": 7,
      "value": "#Scenario: User Login invalid user id"
    },
    {
      "line": 8,
      "value": "#Scenario: User Logout"
    },
    {
      "line": 9,
      "value": "#Scenario: User Login invalid pin"
    },
    {
      "line": 10,
      "value": "#Scenario: Capture Site Location Name"
    },
    {
      "line": 11,
      "value": "#Scenario: Capture Work Area"
    },
    {
      "line": 12,
      "value": "#Scenario: Shift Details full entry"
    },
    {
      "line": 13,
      "value": "#Scenario: Shift Details partial entry"
    },
    {
      "line": 14,
      "value": "#"
    }
  ],
  "line": 16,
  "name": "User Authentication",
  "description": "",
  "id": "user-authentication",
  "keyword": "Feature",
  "tags": [
    {
      "line": 15,
      "name": "@userauthentication"
    }
  ]
});
formatter.scenarioOutline({
  "line": 19,
  "name": "User Login invalid user id",
  "description": "",
  "id": "user-authentication;user-login-invalid-user-id",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@pdaptt-153"
    },
    {
      "line": 18,
      "name": "@sprint1"
    },
    {
      "line": 18,
      "name": "@check"
    },
    {
      "line": 18,
      "name": "@regression"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "User is not already logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "User enters their unique \"\u003cuser ID\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "User enters their \"\u003cpin\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "User proceeds to login",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "User should not be logged on",
  "keyword": "Then "
});
formatter.examples({
  "line": 26,
  "name": "login data",
  "description": "",
  "id": "user-authentication;user-login-invalid-user-id;login-data",
  "rows": [
    {
      "cells": [
        "user ID",
        "pin"
      ],
      "line": 27,
      "id": "user-authentication;user-login-invalid-user-id;login-data;1"
    },
    {
      "cells": [
        "tester",
        "1234"
      ],
      "line": 28,
      "id": "user-authentication;user-login-invalid-user-id;login-data;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1174518,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "User Login invalid user id",
  "description": "",
  "id": "user-authentication;user-login-invalid-user-id;login-data;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@check"
    },
    {
      "line": 18,
      "name": "@regression"
    },
    {
      "line": 18,
      "name": "@sprint1"
    },
    {
      "line": 18,
      "name": "@pdaptt-153"
    },
    {
      "line": 15,
      "name": "@userauthentication"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "User is not already logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "User enters their unique \"tester\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "User enters their \"1234\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "User proceeds to login",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "User should not be logged on",
  "keyword": "Then "
});
formatter.match({
  "location": "TrafficStepDef.user_is_not_already_logged_in()"
});
formatter.result({
  "duration": 3893440790,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "tester",
      "offset": 26
    }
  ],
  "location": "TrafficStepDef.user_enters_their_unique(String)"
});
formatter.result({
  "duration": 1029675062,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1234",
      "offset": 19
    }
  ],
  "location": "TrafficStepDef.user_enters_their(String)"
});
formatter.result({
  "duration": 963089383,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_proceeds_to_login()"
});
formatter.result({
  "duration": 681554173,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_should_not_be_logged_on()"
});
formatter.result({
  "duration": 621633975,
  "status": "passed"
});
formatter.after({
  "duration": 13432,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 43,
  "name": "User Login successful",
  "description": "",
  "id": "user-authentication;user-login-successful",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@pdaptt-153"
    },
    {
      "line": 42,
      "name": "@sprint1"
    },
    {
      "line": 42,
      "name": "@regression"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "User is not already logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "User enters their unique \"\u003cuser ID\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "User enters their \"\u003cpin\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "User proceeds to login",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "User should be logged in successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 50,
  "name": "login data",
  "description": "",
  "id": "user-authentication;user-login-successful;login-data",
  "rows": [
    {
      "cells": [
        "user ID",
        "pin"
      ],
      "line": 51,
      "id": "user-authentication;user-login-successful;login-data;1"
    },
    {
      "cells": [
        "michael.umenyiora",
        "5678"
      ],
      "line": 52,
      "id": "user-authentication;user-login-successful;login-data;2"
    },
    {
      "cells": [
        "maurizio.pietrantuono",
        "1234"
      ],
      "line": 53,
      "id": "user-authentication;user-login-successful;login-data;3"
    },
    {
      "cells": [
        "sonia.dunkley",
        "1234"
      ],
      "line": 54,
      "id": "user-authentication;user-login-successful;login-data;4"
    },
    {
      "cells": [
        "john.smith",
        "1234"
      ],
      "line": 55,
      "id": "user-authentication;user-login-successful;login-data;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 329481,
  "status": "passed"
});
formatter.scenario({
  "line": 52,
  "name": "User Login successful",
  "description": "",
  "id": "user-authentication;user-login-successful;login-data;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@regression"
    },
    {
      "line": 42,
      "name": "@sprint1"
    },
    {
      "line": 42,
      "name": "@pdaptt-153"
    },
    {
      "line": 15,
      "name": "@userauthentication"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "User is not already logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "User enters their unique \"michael.umenyiora\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "User enters their \"5678\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "User proceeds to login",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "User should be logged in successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "TrafficStepDef.user_is_not_already_logged_in()"
});
formatter.result({
  "duration": 158029037,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "michael.umenyiora",
      "offset": 26
    }
  ],
  "location": "TrafficStepDef.user_enters_their_unique(String)"
});
formatter.result({
  "duration": 1287327605,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5678",
      "offset": 19
    }
  ],
  "location": "TrafficStepDef.user_enters_their(String)"
});
formatter.result({
  "duration": 849687309,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_proceeds_to_login()"
});
formatter.result({
  "duration": 655684740,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_should_be_logged_in_successfully()"
});
formatter.result({
  "duration": 27548327901,
  "status": "passed"
});
formatter.after({
  "duration": 21728,
  "status": "passed"
});
formatter.before({
  "duration": 305778,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "User Login successful",
  "description": "",
  "id": "user-authentication;user-login-successful;login-data;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@regression"
    },
    {
      "line": 42,
      "name": "@sprint1"
    },
    {
      "line": 42,
      "name": "@pdaptt-153"
    },
    {
      "line": 15,
      "name": "@userauthentication"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "User is not already logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "User enters their unique \"maurizio.pietrantuono\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "User enters their \"1234\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "User proceeds to login",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "User should be logged in successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "TrafficStepDef.user_is_not_already_logged_in()"
});
formatter.result({
  "duration": 25364840691,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "maurizio.pietrantuono",
      "offset": 26
    }
  ],
  "location": "TrafficStepDef.user_enters_their_unique(String)"
});
formatter.result({
  "duration": 1501846124,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1234",
      "offset": 19
    }
  ],
  "location": "TrafficStepDef.user_enters_their(String)"
});
formatter.result({
  "duration": 934425679,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_proceeds_to_login()"
});
formatter.result({
  "duration": 661340050,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_should_be_logged_in_successfully()"
});
formatter.result({
  "duration": 30116182518,
  "status": "passed"
});
formatter.after({
  "duration": 15802,
  "status": "passed"
});
formatter.before({
  "duration": 293531,
  "status": "passed"
});
formatter.scenario({
  "line": 54,
  "name": "User Login successful",
  "description": "",
  "id": "user-authentication;user-login-successful;login-data;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@regression"
    },
    {
      "line": 42,
      "name": "@sprint1"
    },
    {
      "line": 42,
      "name": "@pdaptt-153"
    },
    {
      "line": 15,
      "name": "@userauthentication"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "User is not already logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "User enters their unique \"sonia.dunkley\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "User enters their \"1234\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "User proceeds to login",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "User should be logged in successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "TrafficStepDef.user_is_not_already_logged_in()"
});
formatter.result({
  "duration": 4347536592,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sonia.dunkley",
      "offset": 26
    }
  ],
  "location": "TrafficStepDef.user_enters_their_unique(String)"
});
formatter.result({
  "duration": 1218214716,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1234",
      "offset": 19
    }
  ],
  "location": "TrafficStepDef.user_enters_their(String)"
});
formatter.result({
  "duration": 1010791506,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_proceeds_to_login()"
});
formatter.result({
  "duration": 657938173,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_should_be_logged_in_successfully()"
});
formatter.result({
  "duration": 30827980642,
  "status": "passed"
});
formatter.after({
  "duration": 13432,
  "status": "passed"
});
formatter.before({
  "duration": 291160,
  "status": "passed"
});
formatter.scenario({
  "line": 55,
  "name": "User Login successful",
  "description": "",
  "id": "user-authentication;user-login-successful;login-data;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@regression"
    },
    {
      "line": 42,
      "name": "@sprint1"
    },
    {
      "line": 42,
      "name": "@pdaptt-153"
    },
    {
      "line": 15,
      "name": "@userauthentication"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "User is not already logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "User enters their unique \"john.smith\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "User enters their \"1234\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "User proceeds to login",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "User should be logged in successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "TrafficStepDef.user_is_not_already_logged_in()"
});
formatter.result({
  "duration": 14937993481,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "john.smith",
      "offset": 26
    }
  ],
  "location": "TrafficStepDef.user_enters_their_unique(String)"
});
formatter.result({
  "duration": 1030385383,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1234",
      "offset": 19
    }
  ],
  "location": "TrafficStepDef.user_enters_their(String)"
});
formatter.result({
  "duration": 984410469,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_proceeds_to_login()"
});
formatter.result({
  "duration": 657050469,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_should_be_logged_in_successfully()"
});
formatter.result({
  "duration": 32535738075,
  "status": "passed"
});
formatter.after({
  "duration": 12642,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 59,
  "name": "User Logout",
  "description": "",
  "id": "user-authentication;user-logout",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 58,
      "name": "@pdaptt-121"
    },
    {
      "line": 58,
      "name": "@sprint1"
    },
    {
      "line": 58,
      "name": "@logout"
    },
    {
      "line": 58,
      "name": "@regression"
    }
  ]
});
formatter.step({
  "line": 60,
  "name": "User is not already logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 61,
  "name": "User enters their unique \"\u003cuser ID\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 62,
  "name": "User enters their \"\u003cpin\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "User proceeds to login",
  "keyword": "And "
});
formatter.step({
  "line": 64,
  "name": "The user logs out",
  "keyword": "And "
});
formatter.step({
  "line": 65,
  "name": "User should return to the login screen",
  "keyword": "Then "
});
formatter.examples({
  "line": 67,
  "name": "login data",
  "description": "",
  "id": "user-authentication;user-logout;login-data",
  "rows": [
    {
      "cells": [
        "user ID",
        "pin"
      ],
      "line": 68,
      "id": "user-authentication;user-logout;login-data;1"
    },
    {
      "cells": [
        "michael.umenyiora",
        "5678"
      ],
      "line": 69,
      "id": "user-authentication;user-logout;login-data;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 309728,
  "status": "passed"
});
formatter.scenario({
  "line": 69,
  "name": "User Logout",
  "description": "",
  "id": "user-authentication;user-logout;login-data;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 58,
      "name": "@regression"
    },
    {
      "line": 58,
      "name": "@pdaptt-121"
    },
    {
      "line": 58,
      "name": "@sprint1"
    },
    {
      "line": 58,
      "name": "@logout"
    },
    {
      "line": 15,
      "name": "@userauthentication"
    }
  ]
});
formatter.step({
  "line": 60,
  "name": "User is not already logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 61,
  "name": "User enters their unique \"michael.umenyiora\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 62,
  "name": "User enters their \"5678\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "User proceeds to login",
  "keyword": "And "
});
formatter.step({
  "line": 64,
  "name": "The user logs out",
  "keyword": "And "
});
formatter.step({
  "line": 65,
  "name": "User should return to the login screen",
  "keyword": "Then "
});
formatter.match({
  "location": "TrafficStepDef.user_is_not_already_logged_in()"
});
formatter.result({
  "duration": 3399253333,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "michael.umenyiora",
      "offset": 26
    }
  ],
  "location": "TrafficStepDef.user_enters_their_unique(String)"
});
formatter.result({
  "duration": 1332730864,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5678",
      "offset": 19
    }
  ],
  "location": "TrafficStepDef.user_enters_their(String)"
});
formatter.result({
  "duration": 880011457,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_proceeds_to_login()"
});
formatter.result({
  "duration": 657301333,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.the_user_logs_out()"
});
formatter.result({
  "duration": 23860980543,
  "status": "passed"
});
formatter.match({
  "location": "TrafficStepDef.user_should_return_to_the_login_screen()"
});
formatter.result({
  "duration": 4194752396,
  "status": "passed"
});
formatter.after({
  "duration": 37926,
  "status": "passed"
});
});