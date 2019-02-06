
| Functionnality | Code |  
| -- | -- |  
| Scroll with offset | js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -60);", element); |  
| Get the innerHTML, if getText() doesn't work | String EventCountValue = EventCount.getAttribute("innerHTML"); |  
| Find first element that contains "Evenement | WebElement EventText = driver.findElement(By.xpath("//parent::*[contains(text(), 'Evenement')]")); |  
| Waits that an element is visible in the window | wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-risk-assessment-list/section/div/ul/li[3]"))); |  
| Wait that an element is present in DOM | wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-banner/span/header/nav/div/a/span/img"))); |
| Add screenshot to report (screenshot must exists before using it) | Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + ".png"); |
| Find by xpath css class | By.xpath("//div[@class='panel-collapse collapse']") |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |