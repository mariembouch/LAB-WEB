import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Publication } from 'src/models/publication';
import { PublicationService } from 'src/services/publication.service';

@Component({
  selector: 'app-article-create',
  templateUrl: './article-create.component.html',
  styleUrls: ['./article-create.component.css']
})
export class ArticleCreateComponent implements OnInit {
  form: FormGroup; // Ensure form is always initialized
  pubGlobal!: Publication;

  constructor(
    private PS: PublicationService,
    private router: Router,
    private dialogRef: MatDialogRef<ArticleCreateComponent>,
    private activatedRoute: ActivatedRoute
  ) {
    // Initialize the form with empty values to avoid undefined errors
    this.form = new FormGroup({
      titre: new FormControl(null, [Validators.required]),
      lien: new FormControl(null, [Validators.required]),
      date: new FormControl(null),
      sourcepdf: new FormControl(null, [Validators.required]),
    });
  }

  ngOnInit(): void {
    const idCourant1 = this.activatedRoute.snapshot.params['id'];
    console.log(idCourant1);

    if (!!idCourant1) {
      // If ID is present, load the publication and update the form
      this.PS.getPublicationById(idCourant1).subscribe((pub) => {
        this.pubGlobal = pub;
        this.form.patchValue(pub); // Update form values with fetched data
      });
    }
  }

  close(): void {
    this.dialogRef.close();
  }

  save(): void {
    if (this.form.valid) {
      this.dialogRef.close(this.form.value); // Pass form values to the dialog's close function
    } else {
      console.error('Form is invalid:', this.form.errors);
    }
  }
}
