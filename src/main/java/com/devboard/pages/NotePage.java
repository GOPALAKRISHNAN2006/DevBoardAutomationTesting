
package com.devboard.pages;
import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.devboard.base.BasePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotePage extends BasePage {

    public NotePage(WebDriver driver) {
        super(driver);
    }

    // Buttons

    private By newNoteButton =
            By.cssSelector("[data-testid='new-note-button']");

    private By saveNoteButton =
            By.cssSelector("[data-testid='save-note-button']");

    private By closeNoteButton =
            By.cssSelector("[data-testid='close-note-button']");

    // Inputs
    private By titleInput =
            By.cssSelector("[data-testid='note-title-input']");

    private By tagsInput =
            By.cssSelector("[data-testid='note-tags-input']");

    private By contentInput =
            By.cssSelector("[data-testid='note-content-input']");


    // Click New Note
    public void clickNewNote() {

        WaitUtils.waitForClickable(
                driver,
                newNoteButton
        );

        click(newNoteButton);
    }


    // Enter title
    public void enterTitle(String title) {

        WaitUtils.waitForVisible(
                driver,
                titleInput
        );

        type(titleInput, title);
    }


    // Enter tags
    public void enterTags(String tags) {

        type(tagsInput, tags);
    }


    // Enter content
    public void enterContent(String content) {

        type(contentInput, content);
    }


    // Save note
    public void clickSave() {

        WaitUtils.waitForClickable(
                driver,
                saveNoteButton
        );

        click(saveNoteButton);
    }


    // Complete create-note flow
    public void createNote(
            String title,
            String content,
            String tags) {

        clickNewNote();

        enterTitle(title);

        enterContent(content);

        enterTags(tags);

        clickSave();
    }


    // Verify note exists
    public boolean isNotePresent(String title) {

        By noteTitle = By.xpath(
                "//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']"
        );

        try {

            WaitUtils.waitForVisible(
                    driver,
                    noteTitle
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // Search Note
    public void searchNote(String searchText) {

        By searchInput =
                By.cssSelector("[data-testid='notes-search-input']");

        WaitUtils.waitForVisible(
                driver,
                searchInput
        );

        type(searchInput, searchText);
    }

    // Edit Note

    // Edit Note
    public void clickEditNote(String title) {

        By noteItem = By.xpath(
                "//div[contains(@class,'note-item')" +
                        " and .//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']]"
        );

        WaitUtils.waitForVisible(
                driver,
                noteItem
        );

        WebElement note =
                driver.findElement(noteItem);

        new Actions(driver)
                .moveToElement(note)
                .perform();

        WebElement editButton =
                note.findElement(
                        By.cssSelector(
                                "button[data-testid^='edit-note-button-']"
                        )
                );

        editButton.click();
    }
    public void editNote(String oldTitle, String newTitle) {

        clickEditNote(oldTitle);

        enterTitle(newTitle);

        clickSave();
    }

    // Delete Note
    public void clickDeleteNote(String title) {

        By noteItemLocator = By.xpath(
                "//div[contains(@class,'note-item')]" +
                        "[.//span[contains(@class,'note-item-title')]" +
                        "[normalize-space()='" + title + "']]"
        );

        WaitUtils.waitForVisible(
                driver,
                noteItemLocator
        );

        WebElement noteItem =
                driver.findElement(noteItemLocator);

        WebElement deleteButton =
                noteItem.findElement(
                        By.cssSelector(
                                "button[data-testid^='delete-note-button-']"
                        )
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        deleteButton
                );

        WaitUtils.waitForAlert(driver);

        driver.switchTo().alert().accept();
    }

    public boolean waitUntilNoteDeleted(String title) {

        By noteItem = By.xpath(
                "//div[contains(@class,'note-item')" +
                        " and .//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']]"
        );

        try {
            WaitUtils.waitForInvisible(
                    driver,
                    noteItem
            );

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    // Oin or Umpin
    public void clickPinNote(String title) {

        By noteItemLocator = By.xpath(
                "//div[contains(@class,'note-item')]" +
                        "[.//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']]"
        );

        WaitUtils.waitForVisible(
                driver,
                noteItemLocator
        );

        WebElement noteItem =
                driver.findElement(noteItemLocator);

        WebElement pinButton =
                noteItem.findElement(
                        By.cssSelector(
                                "button[data-testid^='pin-note-button-']"
                        )
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        pinButton
                );
    }

    public boolean isNotePinned(String title) {

        By unpinButton = By.xpath(
                "//div[contains(@class,'note-item')]" +
                        "[.//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']]" +
                        "//button[@title='Unpin']"
        );

        try {
            WaitUtils.waitForVisible(
                    driver,
                    unpinButton
            );

            return true;

        } catch (Exception e) {
            return false;
        }
    }


    public void ensureUnpinned(String title) {

        if (isNotePinned(title)) {

            clickPinNote(title);

            waitUntilUnpinned(title);
        }
    }

    public boolean waitUntilPinned(String title) {

        By unpinButton = By.xpath(
                "//div[contains(@class,'note-item')]" +
                        "[.//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']]" +
                        "//button[starts-with(@data-testid,'pin-note-button-')]"
        );

        try {

            WebDriverWait wait =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(10)
                    );

            wait.until(driver -> {

                try {

                    WebElement button =
                            driver.findElement(unpinButton);

                    return "Unpin".equals(
                            button.getAttribute("title")
                    );

                } catch (Exception e) {

                    return false;
                }
            });

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean waitUntilUnpinned(String title) {

        By pinButton = By.xpath(
                "//div[contains(@class,'note-item')]" +
                        "[.//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']]" +
                        "//button[starts-with(@data-testid,'pin-note-button-')]"
        );

        try {

            WebDriverWait wait =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(10)
                    );

            wait.until(driver -> {

                try {

                    WebElement button =
                            driver.findElement(pinButton);

                    return "Pin".equals(
                            button.getAttribute("title")
                    );

                } catch (Exception e) {

                    return false;
                }
            });

            return true;

        } catch (Exception e) {

            return false;
        }
    }


    // Archive and Unarchive

    private By archivedFilter =
            By.cssSelector("[data-testid='notes-filter-archived']");

    private By activeFilter =
            By.cssSelector("[data-testid='notes-filter-active']");

    public void clickActiveFilter() {

        WaitUtils.waitForClickable(
                driver,
                activeFilter
        );

        click(activeFilter);
    }

    public void clickArchiveNote(String title) {

        By noteItemLocator = By.xpath(
                "//div[contains(@class,'note-item')]" +
                        "[.//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']]"
        );

        WaitUtils.waitForVisible(
                driver,
                noteItemLocator
        );

        WebElement noteItem =
                driver.findElement(noteItemLocator);

        WebElement archiveButton =
                noteItem.findElement(
                        By.cssSelector(
                                "button[data-testid^='archive-note-button-']"
                        )
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        archiveButton
                );
    }
    public void clickArchivedFilter() {

        WaitUtils.waitForClickable(
                driver,
                archivedFilter
        );

        click(archivedFilter);
    }

    public boolean waitUntilNoteDisappears(String title) {

        By noteItem = By.xpath(
                "//div[contains(@class,'note-item')]" +
                        "[.//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']]"
        );

        try {

            WebDriverWait wait =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(10)
                    );

            wait.until(driver ->
                    driver.findElements(noteItem).isEmpty()
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }
    public boolean waitUntilArchived(String title) {

        By archivedNoteButton = By.xpath(
                "//div[contains(@class,'note-item')]" +
                        "[.//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']]" +
                        "//button[@title='Unarchive']"
        );

        try {
            WebDriverWait wait =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(10)
                    );

            wait.until(driver -> {
                try {
                    WebElement button =
                            driver.findElement(archivedNoteButton);

                    return "Unarchive".equals(
                            button.getAttribute("title")
                    );
                } catch (Exception e) {
                    return false;
                }
            });

            return true;

        } catch (Exception e) {
            return false;
        }
    }
    public boolean waitUntilUnarchived(String title) {

        By activeNoteButton = By.xpath(
                "//div[contains(@class,'note-item')]" +
                        "[.//span[contains(@class,'note-item-title')" +
                        " and normalize-space()='" + title + "']]" +
                        "//button[@title='Archive']"
        );

        try {
            WebDriverWait wait =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(10)
                    );

            wait.until(driver -> {
                try {
                    WebElement button =
                            driver.findElement(activeNoteButton);

                    return "Archive".equals(
                            button.getAttribute("title")
                    );
                } catch (Exception e) {
                    return false;
                }
            });

            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
