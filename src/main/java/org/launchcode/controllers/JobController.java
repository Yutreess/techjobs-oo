package org.launchcode.controllers;

import org.launchcode.models.PositionType;
import org.launchcode.models.CoreCompetency;
import org.launchcode.models.Location;
import org.launchcode.models.Employer;
import org.launchcode.models.Job;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        model.addAttribute("job", jobData.findById(id));
        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid JobForm jobForm, Errors errors) {

        // Job Fields from JobForm
        String newJobName = jobForm.getName();
        Employer newJobEmployer = jobForm.getEmployer();
        Location newJobLocation = jobForm.getLocation();
        PositionType newJobPositionType = jobForm.getPositionType();
        CoreCompetency newJobCoreCompetency = jobForm.getCoreCompetency();

        // Reload form if something goes wrong
        if (errors.hasErrors()) {
            return "new-job";
        }

        Job newJob = new Job( //String aName
                                newJobName,
                              //Employer aEmployer
                                newJobEmployer,
                              //Location aLocation
                                newJobLocation,
                              //PositionType aPositionType
                                newJobPositionType,
                              //CoreCompetency aSkill
                                newJobCoreCompetency
        );

        jobData.add(newJob);

        return "redirect:/job?id=" + newJob.getId();

    }
}
