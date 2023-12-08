package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    // onve we created EventData class we have to remove the following initialize
    //private static List<Event> events = new ArrayList<>();
    //private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        //change the following line of code by EventData.getAll()
        //model.addAttribute("events", events);
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription, @RequestParam String eventCountry) {
        //change the following too
        //events.add(new Event(eventName,eventDescription,eventCountry));
        EventData.add(new Event(eventName,eventDescription,eventCountry));
        //events.add(eventName);
        return "redirect:/events";
    }
    //allow us to delete the event
    @GetMapping("delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }
    //need a POST handler to take care of what to do when the delete event information is submitted by the user
    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam (required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
       }
        return "redirect:/events";
    }

}
