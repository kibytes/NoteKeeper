package com.apps.notekeeper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertCourses() {
        insertCourse("basic_one", "1.Who do you listen to?");
        insertCourse("basic_two", "2.Teachability Index");
        insertCourse("basic_three", "3.Training Balance Scale");
        insertCourse("basic_four", "4.Four steps of Learning");
        insertCourse("basic_five", "5.Master the 4 Basics");
    }

    public void insertSampleNotes() {
        insertNote("basic_one", "Who do you listen to and why",
                "You listen to people whao have what you want.");
        insertNote("basic_two", "How do you determine how teachable you are",
                "There are two variables that are used to determine my teachablitiy");

        insertNote("basic_three", "What is the Training Balance Scale",
                "It describes the focus areas that you have when trying to reach a goal");
        insertNote("basic_four", "What is learning",
                "Learning is being able to demonstrate an application of a new concept");

        insertNote("basic_five", "Why do you master the four basics",
                "It is required when becoming a master of the L.O.A. to have a really firm grasp");
    }

    private void insertCourse(String courseId, String title) {
        ContentValues values = new ContentValues();
        values.put(NoteKeeperDatabaseContract.CourseInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(NoteKeeperDatabaseContract.CourseInfoEntry.COLUMN_COURSE_TITLE, title);

        long newRowId = mDb.insert(NoteKeeperDatabaseContract.CourseInfoEntry.TABLE_NAME, null, values);
    }

     private void insertNote(String courseId, String title, String text) {
        ContentValues values = new ContentValues();
        values.put(NoteKeeperDatabaseContract.NoteInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(NoteKeeperDatabaseContract.NoteInfoEntry.COLUMN_NOTE_TITLE, title);
        values.put(NoteKeeperDatabaseContract.NoteInfoEntry.COLUMN_NOTE_TEXT, text);

        long newRowId = mDb.insert(NoteKeeperDatabaseContract.NoteInfoEntry.TABLE_NAME, null, values);
    }

}
