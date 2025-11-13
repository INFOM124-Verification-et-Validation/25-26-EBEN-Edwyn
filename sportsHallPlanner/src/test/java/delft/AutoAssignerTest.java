class AutoassignerTest {
    @Test
    void testAutoAssign() {
        // Setup test data
        List<Team> teams = Arrays.asList(new Team("Team A"), new Team("Team B"));
        List<TimeSlot> timeSlots = Arrays.asList(new TimeSlot("Monday 10AM"), new TimeSlot("Tuesday 2PM"));

        // Call the method to be tested
        AutoAssigner autoAssigner = new AutoAssigner();
        Map<Team, TimeSlot> assignments = autoAssigner.autoAssign(teams, timeSlots);

        // Verify the results
        assertEquals(teams.size(), assignments.size());
        for (Team team : teams) {
            assertTrue(assignments.containsKey(team));
        }
    }


    public void testtwoworkshops() {
        // Setup test data for two workshops
        List<Workshop> workshops = Arrays.asList(new Workshop("Workshop 1"), new Workshop("Workshop 2"));
        List<Instructor> instructors = Arrays.asList(new Instructor("Instructor A"), new Instructor("Instructor B"));

        // Call the method to be tested
        AutoAssigner autoAssigner = new AutoAssigner();
        Map<Workshop, Instructor> assignments = autoAssigner.autoAssignWorkshops(workshops, instructors);

        // Verify the results
        assertEquals(workshops.size(), assignments.size());
        for (Workshop workshop : workshops) {
            assertTrue(assignments.containsKey(workshop));
        }
    }

    public void testtwodates() {
        // Setup test data for two dates
        List<Event> events = Arrays.asList(new Event("Event 1"), new Event("Event 2"));
        List<Date> dates = Arrays.asList(new Date("2024-07-01"), new Date("2024-07-02"));

        // Call the method to be tested
        AutoAssigner autoAssigner = new AutoAssigner();
        Map<Event, Date> assignments = autoAssigner.autoAssignDates(events, dates);

        // Verify the results
        assertEquals(events.size(), assignments.size());
        for (Event event : events) {
            assertTrue(assignments.containsKey(event));
        }
    }

    public void testhappypath() {
        // Setup test data for happy path
        List<Participant> participants = Arrays.asList(new Participant("Participant 1"), new Participant("Participant 2"));
        List<Activity> activities = Arrays.asList(new Activity("Activity A"), new Activity("Activity B"));

        // Call the method to be tested
        AutoAssigner autoAssigner = new AutoAssigner();
        Map<Participant, Activity> assignments = autoAssigner.autoAssignActivities(participants, activities);

        // Verify the results
        assertEquals(participants.size(), assignments.size());
        for (Participant participant : participants) {
            assertTrue(assignments.containsKey(participant));
        }
    }

    public void testnoplaceavailable() {
        // Setup test data with no available places
        List<Team> teams = Arrays.asList(new Team("Team A"), new Team("Team B"));
        List<TimeSlot> timeSlots = Collections.emptyList(); // No available time slots

        // Call the method to be tested
        AutoAssigner autoAssigner = new AutoAssigner();
        Map<Team, TimeSlot> assignments = autoAssigner.autoAssign(teams, timeSlots);

        // Verify the results
        assertTrue(assignments.isEmpty());
    }

    public void testoverlappingrequests() {
        // Setup test data with overlapping requests
        List<Team> teams = Arrays.asList(new Team("Team A"), new Team("Team B"));
        List<TimeSlot> timeSlots = Arrays.asList(new TimeSlot("Monday 10AM")); // Only one time slot

        // Call the method to be tested
        AutoAssigner autoAssigner = new AutoAssigner();
        Map<Team, TimeSlot> assignments = autoAssigner.autoAssign(teams, timeSlots);

        // Verify the results
        assertEquals(1, assignments.size()); // Only one team can be assigned
    }

}
