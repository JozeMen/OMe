package com.orginizer.OMe.controllers;

import com.orginizer.OMe.dto.MeetingDTO;
import com.orginizer.OMe.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class MeetingController {
    @Autowired
    private MeetingService meetingService;
    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/meets")
    public String getAllMeetings(Model model) {
        model.addAttribute("meetings", meetingService.getAllMeetings());
        return "meetingSchedule";
    }
    @GetMapping("/meets/new")
    public String showCreateMeetingForm(Model model) {
        model.addAttribute("meeting", new MeetingDTO());
        return "createMeeting";
    }

    @PostMapping("/meets/new")
    public String addMeeting(@ModelAttribute MeetingDTO meetingDTO, Model model) {
        boolean result = meetingService.createMeeting(meetingDTO);
        if (!result) {
            model.addAttribute("error", "Время встречи пересекается с другой встречей!");
        }
        return "redirect:/meets";
    }

    @DeleteMapping("/meets/{meetingName}")
    public String addMeeting(@PathVariable("meetingName") String meetingName) {
        meetingService.deleteMeetingByName(meetingName);
        return "redirect:/meets";
    }

    @PutMapping("/meets/edit/{id}")
    public String updateMeeting(@PathVariable("id") Long id, @ModelAttribute MeetingDTO meetingDTO, Model model) {
        boolean updated = meetingService.updateMeeting(id, meetingDTO);
        if (updated) {
            model.addAttribute("message", "Встреча успешно обновлена!");
        } else {
            model.addAttribute("error", "Ошибка обновления");
        }
        return "redirect:/meets";
    }

}
