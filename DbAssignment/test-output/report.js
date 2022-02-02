$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/db/features/assignment.feature");
formatter.feature({
  "name": "Twitter functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on twitter login page",
  "keyword": "Given "
});
formatter.match({
  "location": "TodoSteps.redirect_ToLandingPage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with valid username and password",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user logs in with following credentials",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "@Indrase62452060",
        "Indrasen@1204"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TodoSteps.login(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user expect to be navigated to home page",
  "keyword": "Then "
});
formatter.match({
  "location": "TodoSteps.verifyLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on twitter login page",
  "keyword": "Given "
});
formatter.match({
  "location": "TodoSteps.redirect_ToLandingPage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Upload profile picture and update profile details",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user logs in with following credentials",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "@Indrase62452060",
        "Indrasen@1204"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TodoSteps.login(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to profile page to upload a profile picture",
  "keyword": "And "
});
formatter.match({
  "location": "TodoSteps.userUploadProfilePicture()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user update following details in profile section",
  "rows": [
    {
      "cells": [
        "bio",
        "Selenium Automation Expert1"
      ]
    },
    {
      "cells": [
        "location",
        "Pune1"
      ]
    },
    {
      "cells": [
        "website",
        "twitter123.com"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "TodoSteps.updateProfileSection(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user expect following details updated in profile section",
  "rows": [
    {
      "cells": [
        "bio",
        "Selenium Automation Expert1"
      ]
    },
    {
      "cells": [
        "location",
        "Pune1"
      ]
    },
    {
      "cells": [
        "website",
        "http://twitter123.com"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "TodoSteps.verifyProfileSection(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on twitter login page",
  "keyword": "Given "
});
formatter.match({
  "location": "TodoSteps.redirect_ToLandingPage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Retrieve the tweets",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user logs in with following credentials",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "@Indrase62452060",
        "Indrasen@1204"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TodoSteps.login(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user retrieves the tweets for the twitter page of \"The Times Of India\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TodoSteps.retrieveTheTweets(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});